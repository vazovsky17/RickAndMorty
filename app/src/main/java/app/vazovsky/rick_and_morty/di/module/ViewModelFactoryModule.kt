package app.vazovsky.rick_and_morty.di.module

import androidx.lifecycle.ViewModelProvider
import app.vazovsky.rick_and_morty.di.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}