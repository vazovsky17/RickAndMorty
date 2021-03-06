package app.vazovsky.rick_and_morty.di.module

import androidx.lifecycle.ViewModel
import app.vazovsky.rick_and_morty.di.util.ViewModelKey
import app.vazovsky.rick_and_morty.presentation.character.detail.CharacterDetailViewModel
import app.vazovsky.rick_and_morty.presentation.character.filter.CharacterFilterViewModel
import app.vazovsky.rick_and_morty.presentation.character.list.CharacterListViewModel
import app.vazovsky.rick_and_morty.presentation.episode.detail.EpisodeDetailViewModel
import app.vazovsky.rick_and_morty.presentation.episode.list.EpisodeListViewModel
import app.vazovsky.rick_and_morty.presentation.loading.LoadingViewModel
import app.vazovsky.rick_and_morty.presentation.location.detail.LocationDetailViewModel
import app.vazovsky.rick_and_morty.presentation.location.list.LocationListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
abstract class ViewModelModule {

    /** LOADING */
    @Binds
    @IntoMap
    @ViewModelKey(LoadingViewModel::class)
    abstract fun loadingViewModel(viewModel: LoadingViewModel): ViewModel

    /** CHARACTER */
    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailViewModel::class)
    abstract fun characterDetailViewModel(viewModel: CharacterDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    abstract fun characterListViewModel(viewModel: CharacterListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharacterFilterViewModel::class)
    abstract fun characterFilterViewModel(viewModel: CharacterFilterViewModel): ViewModel

    /** EPISODE */
    @Binds
    @IntoMap
    @ViewModelKey(EpisodeDetailViewModel::class)
    abstract fun episodeDetailViewModel(viewModel: EpisodeDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EpisodeListViewModel::class)
    abstract fun episodeListViewModel(viewModel: EpisodeListViewModel): ViewModel

    /** LOCATION */
    @Binds
    @IntoMap
    @ViewModelKey(LocationDetailViewModel::class)
    abstract fun locationDetailViewModel(viewModel: LocationDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LocationListViewModel::class)
    abstract fun locationListViewModel(viewModel: LocationListViewModel): ViewModel
}