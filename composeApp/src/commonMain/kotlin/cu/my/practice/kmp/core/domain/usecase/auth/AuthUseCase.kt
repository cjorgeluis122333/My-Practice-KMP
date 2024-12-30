package cu.my.practice.kmp.core.domain.usecase.auth

class AuthUseCase(
  val loginUseCase: LoginUseCase,
  val registerUseCase: RegisterUseCase
)