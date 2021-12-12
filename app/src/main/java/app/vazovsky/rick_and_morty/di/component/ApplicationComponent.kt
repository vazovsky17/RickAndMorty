package app.vazovsky.rick_and_morty.di.component

import app.vazovsky.rick_and_morty.RaMApplication
import app.vazovsky.rick_and_morty.di.module.ActivityModule
import app.vazovsky.rick_and_morty.di.module.ApiServiceModule
import app.vazovsky.rick_and_morty.di.module.ApplicationModule
import app.vazovsky.rick_and_morty.di.module.FragmentModule
import app.vazovsky.rick_and_morty.di.module.ViewModelFactoryModule
import app.vazovsky.rick_and_morty.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ApiServiceModule::class,
        ApplicationModule::class,
        FragmentModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<RaMApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: RaMApplication): ApplicationComponent
    }
}