package app.vazovsky.rick_and_morty.di.module

import app.vazovsky.rick_and_morty.presentation.detail.DetailFragment
import app.vazovsky.rick_and_morty.presentation.list.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun detailFragment(): DetailFragment

    @ContributesAndroidInjector
    abstract fun listFragment(): ListFragment
}