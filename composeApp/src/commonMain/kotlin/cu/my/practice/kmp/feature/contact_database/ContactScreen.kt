package cu.my.practice.kmp.feature.contact_database

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cu.my.practice.kmp.core.ui.component.GAlert
import cu.my.practice.kmp.core.ui.component.GCustom
import cu.my.practice.kmp.core.ui.component.GIconAlert
import cu.my.practice.kmp.core.ui.component.GToast
import cu.my.practice.kmp.core.ui.component.snackbar.SnackbarController
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ContactScreen(viewModel: ContactViewModel = koinViewModel()) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxWidth().size(300.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var showButtonBar by remember { mutableStateOf(false) }
        Button(onClick = { GToast(message = "Dsad") }) {
            Text("Toast")
        }

        Button(onClick = { GAlert(message = "Dsad") }) {
            Text("Alert")
        }

        Button(onClick = { GIconAlert(message = "Dsad") }) {
            Text("Icon")
        }

        Button(onClick = { GCustom(message = "Dsad") }) {
            Text("Custom")
        }

//        ErrorButtonBar()
        Button(onClick = {
            scope.launch {
                SnackbarController.sendEvent(
                    SnackbarController.SnackbarEvent(
                        message = "Check your internet connection",
                        action = SnackbarController.SnackbarAction(
                            buttonName = "retry",
                            action = {}
                        )
                    )
                )
            }
        }) {
            Text("sadasd")
        }

    }

}