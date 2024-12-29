package cu.my.practice.kmp.core.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class AndroidCoroutine() : Coroutine {
    override val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
}
actual fun provideCoroutine(): Coroutine = AndroidCoroutine()