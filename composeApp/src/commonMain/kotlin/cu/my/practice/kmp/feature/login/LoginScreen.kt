package cu.my.practice.kmp.feature.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cu.my.practice.kmp.core.ui.Route
import cu.my.practice.kmp.feature.login.state.LoginState
import cu.my.practice.kmp.feature.login.state.SussesLogin
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    navigateTo: (Route) -> Unit,
    loginViewModel: LoginViewModel = koinViewModel()
) {
    val state by loginViewModel.state.collectAsStateWithLifecycle()
    Scaffold {
        LaunchedEffect(key1 = loginViewModel.onSussesLogin) {
            loginViewModel.onSussesLogin.collectLatest {
                when (it) {
                    SussesLogin.Susses -> navigateTo(Route.Home)
                }
            }
        }
        Content(
            stateHandle = loginViewModel::stateHandler,
            state = state,
            onLogin = loginViewModel::onLogin,
        )
    }
}

@Composable
private fun Content(
    stateHandle: (String, String) -> Unit,
    state: LoginState,
    onLogin: () -> Unit,
) {
    Column {
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(
                "Login Screen",
                fontSize = MaterialTheme.typography.h2.fontSize,

                )
        }
        Spacer(modifier = Modifier.weight(1f))

        OutlinedTextField(
            onValueChange = { stateHandle(it, state.password) },
            value = state.username,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            placeholder = { Text("Username") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            onValueChange = { stateHandle(state.username, it) },
            value = state.password,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            placeholder = { Text("Password") }

        )
        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            Text("I forget my password", modifier = Modifier.padding(end = 16.dp))
        }
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedButton(onClick = {
            onLogin()
        }, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text("Sing in")
        }
        Spacer(modifier = Modifier.height(8.dp))


        Spacer(modifier = Modifier.height(16.dp))

        if (state.isLoading)
            CircularProgressIndicator()
        if (state.errorMessage != null)
            Text(state.errorMessage ?: "", color = Color.Red)

        Spacer(modifier = Modifier.weight(1f))

    }

}