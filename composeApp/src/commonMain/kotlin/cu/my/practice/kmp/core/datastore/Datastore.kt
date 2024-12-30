package cu.my.practice.kmp.core.datastore

import cu.my.practice.kmp.core.common.Context


expect suspend fun Context.saveData(key: String, `object`: String)
expect suspend fun Context.getData(key: String): String?

expect suspend fun Context.saveDataBoolean(key: String, value: Boolean)
expect suspend fun Context.getDataBoolean(key: String): Boolean?



