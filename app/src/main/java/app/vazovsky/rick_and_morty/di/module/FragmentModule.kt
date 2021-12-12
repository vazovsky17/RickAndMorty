package app.vazovsky.rick_and_morty.di.module

import app.vazovsky.rick_and_morty.presentation.character.detail.CharacterDetailFragment
import app.vazovsky.rick_and_morty.presentation.character.list.CharacterListFragment
import app.vazovsky.rick_and_morty.presentation.episode.detail.EpisodeDetailFragment
import app.vazovsky.rick_and_morty.presentation.episode.list.EpisodeListFragment
import app.vazovsky.rick_and_morty.presentation.location.detail.LocationDetailFragment
import app.vazovsky.rick_and_morty.presentation.location.list.LocationListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    /** CHARACTER */
    @ContributesAndroidInjector
    abstract fun characterDetailFragment(): CharacterDetailFragment

    @ContributesAndroidInjector
    abstract fun characterListFragment(): CharacterListFragment

    /** EPISODE */
    @ContributesAndroidInjector
    abstract fun episodeDetailFragment(): EpisodeDetailFragment

    @ContributesAndroidInjector
    abstract fun episodeListFragment(): EpisodeListFragment

    /** LOCATION */
    @ContributesAndroidInjector
    abstract fun locationDetailFragment(): LocationDetailFragment

    @ContributesAndroidInjector
    abstract fun locationListFragment(): LocationListFragment
}