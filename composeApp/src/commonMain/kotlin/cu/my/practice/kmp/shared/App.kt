package cu.my.practice.kmp.shared

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
import cu.my.practice.kmp.feature.admin.AdminScreen
import cu.my.practice.kmp.feature.admin.AdminViewModel
import cu.my.practice.kmp.feature.contact_database.ContactScreen
import cu.my.practice.kmp.feature.contact_database.ContactViewModel
import cu.my.practice.kmp.feature.home.HomeScreen
import cu.my.practice.kmp.feature.home.HomeViewModel
import cu.my.practice.kmp.feature.login.LoginScreen
import cu.my.practice.kmp.feature.login.LoginViewModel
import cu.my.practice.kmp.feature.register.RegisterScreen
import cu.my.practice.kmp.feature.register.RegisterViewModel
import cu.my.practice.kmp.feature.rick_paging.RickMortyScreen
import cu.my.practice.kmp.feature.rick_paging.RickMortyViewModel
import cu.my.practice.kmp.feature.splash.SplashScreen
import cu.my.practice.kmp.feature.splash.SplashViewModel
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
                composable<Route.Splash> {
                    val splashViewModel = koinViewModel<SplashViewModel>()
                    SplashScreen(viewModel = splashViewModel)
                }

                composable<Route.Login>(
                    exitTransition = { slideOutHorizontally() },
                    enterTransition = { slideInHorizontally() }
                ) {
                    val loginViewModel = koinViewModel<LoginViewModel>()
                    LoginScreen(
                        loginViewModel = loginViewModel,
                        navigateTo = { route: Route -> navController.navigate(route) })
                }


                composable<Route.Register>(
                    exitTransition = { slideOutHorizontally() },
                    enterTransition = { slideInHorizontally() }
                ) {
                    val registerViewModel = koinViewModel<RegisterViewModel>()
                    RegisterScreen(viewModel = registerViewModel)

                }


                composable<Route.Home>(
                    exitTransition = { slideOutHorizontally() },
                    enterTransition = { slideInHorizontally() }
                ) {
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

                composable<Route.Admin>(
                    exitTransition = { slideOutHorizontally() },
                    enterTransition = { slideInHorizontally() }
                ) {
                    val adminViewModel = koinViewModel<AdminViewModel>()
                    AdminScreen(viewModel = adminViewModel)
                }

                composable<Route.Rick>(
                    exitTransition = { slideOutHorizontally() },
                    enterTransition = { slideInHorizontally() }
                ) {
                    val rickViewModel = koinViewModel<RickMortyViewModel>()
                    RickMortyScreen(viewModel = rickViewModel)
                }

                composable<Route.Contact>(
                    exitTransition = { slideOutHorizontally() },
                    enterTransition = { slideInHorizontally() }
                ) {
                    val contactViewModel = koinViewModel<ContactViewModel>()
                    ContactScreen(viewModel = contactViewModel)
                }


            }
        }

    }
}