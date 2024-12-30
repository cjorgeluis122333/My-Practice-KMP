package cu.my.practice.kmp.core.datastore

import cu.my.practice.kmp.core.common.Context

actual suspend fun Context.saveData(
    key: String,
    `object`: String
) {
}

actual suspend fun Context.getData(key: String): String? {
    TODO("Not yet implemented")
}

actual suspend fun Context.getDataBoolean(key: String): Boolean? {
    TODO("Not yet implemented")
}

actual suspend fun Context.saveDataBoolean(
    key: String,
    value: Boolean
) {
}