package cu.my.practice.kmp

import android.app.Application
import cu.my.practice.kmp.shared.di.initKoinNotContext
import org.koin.android.ext.koin.androidContext

class PracticeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinNotContext {
            androidContext(this@PracticeApplication)
        }
    }
}