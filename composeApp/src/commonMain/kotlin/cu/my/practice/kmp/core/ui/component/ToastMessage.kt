package cu.my.practice.kmp.core.ui.component

import ContentWithMessageBar
import NotificationDuration
import NotificationType
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import createNotification
import rememberMessageBarState

//Alert KMP
fun GToast(message: String, duration: NotificationDuration = NotificationDuration.SHORT) {
    val alertNotification = createNotification(type = NotificationType.TOAST)
    alertNotification.show(message = message, title = "My Title", duration)
}

fun GAlert(message: String, duration: NotificationDuration = NotificationDuration.SHORT) {
    val alertNotification = createNotification(type = NotificationType.ALERT)
    alertNotification.show(message = message, title = "My Title", duration)
}

fun GTop(message: String, duration: NotificationDuration = NotificationDuration.SHORT) {
    val alertNotification = createNotification(type = NotificationType.TOP)
    alertNotification.show(message = message, title = "My Title", duration)
}


fun GIconAlert(message: String, duration: NotificationDuration = NotificationDuration.SHORT) {
    val alertNotification =
        createNotification(type = NotificationType.ICON_ALERT(iconName = "pepe"))
    alertNotification.show(message = message, title = "My Title", duration)
}


fun GCustom(message: String, duration: NotificationDuration = NotificationDuration.SHORT) {
    val alertNotification = createNotification(
        type = NotificationType.CUSTOM(
            title = "My title",
            iconName = "My icon name"
        )
    )
    alertNotification.show(message = message, title = "My Title", duration)
}

//                        Button Bar
@Composable
fun SussesButtonBar() {
    val state = rememberMessageBarState()
    ContentWithMessageBar(messageBarState = state) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                state.addSuccess(message = "Successfully Updated.")
            }) {
                Text(text = "Click me")
            }
        }
    }
}

@Composable
fun ErrorButtonBar() {
    val state = rememberMessageBarState()
    ContentWithMessageBar(messageBarState = state, successIcon = Icons.Rounded.Person) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                state.addError(exception = Exception("Internet Unavailable."))
            }) {
                Text(text = "Click me")
            }
        }
    }
}

@Composable
fun SnackBarMessage(snackbarHostState: SnackbarHostState) {

    SnackbarHost(hostState = snackbarHostState) { data ->
        Snackbar(
            action = {
                TextButton(onClick = { /* Acción de reintentar */ }) {
                    Text("Retry", color = MaterialTheme.colorScheme.primary)
                }
            },
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = data.visuals.message)
        }
    }

}