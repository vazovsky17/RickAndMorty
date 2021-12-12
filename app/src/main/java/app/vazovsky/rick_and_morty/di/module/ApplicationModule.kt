package app.vazovsky.rick_and_morty.di.module

import android.app.Application
import android.content.Context
import app.vazovsky.rick_and_morty.RaMApplication
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule {
    @Provides
    fun provideContext(app: RaMApplication): Context {
        return app.applicationContext
    }

    @Provides
    fun provideApplication(app: RaMApplication): Application {
        return app
    }
}