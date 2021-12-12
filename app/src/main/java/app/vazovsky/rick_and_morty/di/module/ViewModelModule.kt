package app.vazovsky.rick_and_morty.di.module

import androidx.lifecycle.ViewModel
import app.vazovsky.rick_and_morty.di.util.ViewModelKey
import app.vazovsky.rick_and_morty.presentation.detail.DetailViewModel
import app.vazovsky.rick_and_morty.presentation.list.ListViewModel
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
    @ViewModelKey(DetailViewModel::class)
    abstract fun detailViewModel(viewModel: DetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun listViewModel(viewModel: ListViewModel): ViewModel
}