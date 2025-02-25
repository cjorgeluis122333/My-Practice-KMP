package cu.my.practice.kmp.core.ui.component.snackbar


import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Here you have access to the suspend fun sendEvent for launch the snackbar
 */
object SnackbarController {

    private val _events = Channel<SnackbarEvent>()
    val events = _events.receiveAsFlow()

    //Show the snackbar in the selected screen
    suspend fun sendEvent(event: SnackbarEvent) {
        _events.send(event)
    }

    /**
     *  If the used fore launch a event or show a information
     *  @param message The text will show you when launch the snackbar
     *  @param action The event happen when you press de buttonName in the snackbar
     */
    data class SnackbarEvent(
        val message: String,
        val action: SnackbarAction? = null
    )

    /**
     * Is the action of the SnackbarEvent
     * @param action The event will launch when you press the buttonName
     */
    data class SnackbarAction(
        val buttonName: String,
        val action: suspend () -> Unit
    )

}