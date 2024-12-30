package cu.my.practice.kmp.core.domain.usecase.auth

import cu.my.practice.kmp.core.domain.repository.AuthRepository

class RegisterUseCase(
    val authRepository: AuthRepository
) {
}