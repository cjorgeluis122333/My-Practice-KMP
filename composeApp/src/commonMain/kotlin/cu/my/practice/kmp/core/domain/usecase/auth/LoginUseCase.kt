package cu.my.practice.kmp.core.domain.usecase.auth

import cu.my.practice.kmp.core.domain.repository.AuthRepository
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.dto.UserLoginRequest
import cu.my.practice.kmp.core.network.response.dto.UserLoginResponse

class LoginUseCase(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(userModel: UserLoginRequest): ResultValue<Boolean> {
        when (val user = authRepository.postLogin(userModel)) {
            is ResultValue.Error -> {
                return ResultValue.Error(user.exception)
            }

            is ResultValue.Success<UserLoginResponse> -> {
                user.data.let {
                    authRepository.saveUserName(it.username)
                    authRepository.saveToken(it.token)

                }
                return ResultValue.Success(true)
            }
        }
    }

}

