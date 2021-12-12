package app.vazovsky.sampledagger.di.component

import app.vazovsky.sampledagger.SampleApplication
import app.vazovsky.sampledagger.di.module.ActivityModule
import app.vazovsky.sampledagger.di.module.ApplicationModule
import app.vazovsky.sampledagger.di.module.FragmentModule
import app.vazovsky.sampledagger.di.module.ViewModelFactoryModule
import app.vazovsky.sampledagger.di.module.ViewModelModule
import app.vazovsky.sampledagger.di.util.ViewModelFactory
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
        ApplicationModule::class,
        FragmentModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<SampleApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: SampleApplication): ApplicationComponent
    }
}