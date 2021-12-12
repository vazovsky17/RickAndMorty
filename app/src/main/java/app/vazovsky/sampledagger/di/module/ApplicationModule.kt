package app.vazovsky.sampledagger.di.module

import android.app.Application
import android.content.Context
import app.vazovsky.sampledagger.SampleApplication
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule {
    @Provides
    fun provideContext(app: SampleApplication): Context {
        return app.applicationContext
    }

    @Provides
    fun provideApplication(app: SampleApplication): Application {
        return app
    }
}