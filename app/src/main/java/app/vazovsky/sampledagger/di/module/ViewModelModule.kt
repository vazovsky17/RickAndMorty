package app.vazovsky.sampledagger.di.module

import androidx.lifecycle.ViewModel
import app.vazovsky.sampledagger.di.util.ViewModelKey
import app.vazovsky.sampledagger.presentation.sample.SampleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Все ViewModel добавляются сюда
 */
@Module(includes = [ViewModelFactoryModule::class])
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SampleViewModel::class)
    abstract fun sampleViewModel(viewModel: SampleViewModel): ViewModel
}