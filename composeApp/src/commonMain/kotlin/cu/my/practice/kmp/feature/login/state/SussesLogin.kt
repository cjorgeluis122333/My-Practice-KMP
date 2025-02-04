package cu.my.practice.kmp.feature.login.state

sealed class SussesLogin{
    data object Susses: SussesLogin()
    data object Failed: SussesLogin()

}