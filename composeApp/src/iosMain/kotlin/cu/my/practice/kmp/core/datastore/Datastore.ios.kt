package cu.my.practice.kmp.core.datastore

import cu.my.practice.kmp.core.common.Context
import kotlinx.coroutines.flow.MutableSharedFlow
import platform.Foundation.NSUserDefaults


actual suspend fun Context.saveData(key: String, `object`: String) {
    val sharedFlow = MutableSharedFlow<String>()
    NSUserDefaults.standardUserDefaults().setObject(`object`, key)
    sharedFlow.emit(`object`)
}

actual suspend inline fun Context.getData(key: String): String? {
    return NSUserDefaults.standardUserDefaults().stringForKey(key)
}

actual suspend fun Context.saveDataBoolean(
    key: String,
    value: Boolean,
) {
    val sharedFlow = MutableSharedFlow<Boolean>()
    NSUserDefaults.standardUserDefaults().setObject(value, key)
    sharedFlow.emit(value)

}

actual suspend fun Context.getDataBoolean(key: String): Boolean? {
    return NSUserDefaults.standardUserDefaults().boolForKey(key)
}