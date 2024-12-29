package cu.my.practice.kmp.core.common.di

import cu.my.practice.kmp.core.common.Coroutine
import cu.my.practice.kmp.core.common.provideCoroutine
import org.koin.dsl.module

val commonModule = module {
    factory <Coroutine>{ provideCoroutine() }
}
