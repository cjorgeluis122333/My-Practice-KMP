package cu.my.practice.kmp.core.network.client

import cu.my.practice.kmp.core.network.util.CONNECTION_NETWORK_TIMEOUT
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object NetworkClientProvider {


    fun createClient(): HttpClient {
        return HttpClient {

            // Configuration the Timeout
            install(HttpTimeout) {
                requestTimeoutMillis = CONNECTION_NETWORK_TIMEOUT
                connectTimeoutMillis = CONNECTION_NETWORK_TIMEOUT
                socketTimeoutMillis = CONNECTION_NETWORK_TIMEOUT
            }

            // Serialisation JSON
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true

                })
            }

            // Logging for watch all red operation and debug easily.
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        println("HTTP Client: $message")
                    }
                }
            }

//            install(DefaultRequest) {
//                url {
//                    protocol = URLProtocol.HTTPS
//                }
//            }
        }
    }
}