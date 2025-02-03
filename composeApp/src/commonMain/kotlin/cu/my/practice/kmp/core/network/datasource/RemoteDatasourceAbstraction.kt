package cu.my.practice.kmp.core.network.datasource

import cu.my.practice.kmp.core.domain.datasource.remote.RemoteDataSource
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.model.exception.NetworkResponseException
import cu.my.practice.kmp.core.model.exception.createExceptionByErrorCode
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ServerResponseException

abstract class RemoteDatasourceAbstraction : RemoteDataSource {
    /**
     * Function for handling errors
     */
    private fun <T : Any> checkError(resultValue: ResultValue<T>): ResultValue<T> =
        if (resultValue is ResultValue.Error) {
            val exception = createExceptionByErrorCode(
                errorCode = (resultValue.exception as? NetworkResponseException)?.errorCode
            )
            ResultValue.Error(exception)
        } else {
            resultValue
        }

    override suspend fun <T : Any> safeApiCall(request: suspend () -> T): ResultValue<T> {
        return try {
            val response = request.invoke()
            ResultValue.Success(response)
        } catch (e: ClientRequestException) {
            // Error 4xx
            checkError(ResultValue.Error(createExceptionByErrorCode(e.response.status.value)))

        } catch (e: ServerResponseException) {
            // Error 5xx
            checkError(ResultValue.Error(createExceptionByErrorCode(e.response.status.value)))

        } catch (e: HttpRequestTimeoutException) {
            // Timeout
            checkError(ResultValue.Error(Exception("Request timed out")))

        } catch (e: kotlinx.io.IOException) {
            // Connection Error
            checkError(ResultValue.Error(Exception("Network connection error")))

        } catch (e: Exception) {
            // Other errors
            checkError(ResultValue.Error(Exception("Unknown error occurred")))

        }
    }
}
