package app.vazovsky.sampledagger.di.module

import androidx.lifecycle.ViewModelProvider
import app.vazovsky.sampledagger.di.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}