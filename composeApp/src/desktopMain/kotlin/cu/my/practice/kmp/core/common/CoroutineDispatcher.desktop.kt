package cu.my.practice.kmp.core.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DesktopCoroutine():Coroutine{
    override val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

}

actual fun provideCoroutine(): Coroutine {
    TODO("Not yet implemented")
}