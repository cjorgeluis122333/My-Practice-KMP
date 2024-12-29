package cu.my.practice.kmp.core.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class IosCoroutine():Coroutine {
    override val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
}

actual fun provideCoroutine(): Coroutine = IosCoroutine()