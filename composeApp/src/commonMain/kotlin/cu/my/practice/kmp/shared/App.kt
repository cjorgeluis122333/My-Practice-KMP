package cu.my.practice.kmp.shared

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import cu.my.practice.kmp.core.ui.Route
import cu.my.practice.kmp.feature.admin.AdminViewModel
import cu.my.practice.kmp.feature.home.HomeScreen
import cu.my.practice.kmp.feature.home.HomeViewModel
import cu.my.practice.kmp.feature.login.LoginScreen
import cu.my.practice.kmp.feature.login.LoginViewModel
import cu.my.practice.kmp.feature.register.RegisterViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        val appViewModel: AppViewModel = koinViewModel()
        val appState by appViewModel.appState.collectAsStateWithLifecycle()
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Route.Graph) {
            navigation<Route.Graph>(startDestination = appViewModel.firstScreen) {

                composable<Route.Login> {
                    val loginViewModel = koinViewModel<LoginViewModel>()
                    LoginScreen(
                        loginViewModel = loginViewModel,
                        navigateTo = { route: Route -> navController.navigate(route) })
                }

                composable<Route.Register> {
                    val registerViewModel = koinViewModel<RegisterViewModel>()
                }


                composable<Route.Home> {
                    val homeViewModel = koinViewModel<HomeViewModel>()
                    HomeScreen(
                        viewModel = homeViewModel,
                        navigateTo = { route: Route -> navController.navigate(route) },
                        logOut = {
                            navController.navigate(Route.Login) {

                                popUpTo<Route.Graph>() {
                                    inclusive = true
                                }
                                launchSingleTop = true

                            }
                        }

                    )
                }

                composable<Route.Admin> {
                    val adminViewModel = koinViewModel<AdminViewModel>()
                }
            }
        }

    }
}