package cu.my.practice.kmp.core.common

import kotlinx.coroutines.CoroutineDispatcher

interface Coroutine {
    val ioDispatcher: CoroutineDispatcher
}
expect fun provideCoroutine(): Coroutine