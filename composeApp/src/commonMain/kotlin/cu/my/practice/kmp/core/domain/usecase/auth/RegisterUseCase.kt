package cu.my.practice.kmp.core.domain.usecase.auth

import cu.my.practice.kmp.core.domain.repository.AuthRepository
import cu.my.practice.kmp.core.model.ResultValue
import cu.my.practice.kmp.core.network.response.UserResponse

class RegisterUseCase(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(userToRegister: UserResponse): ResultValue<Boolean> =
        when (val userRegister = authRepository.postRegister(userToRegister)
        ) {
            is ResultValue.Error -> {
                ResultValue.Error(userRegister.exception)
            }

            is ResultValue.Success<UserResponse> -> {
                ResultValue.Success(true)
            }
        }

}

