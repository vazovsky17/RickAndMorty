package app.vazovsky.sampledagger.di.module

import app.vazovsky.sampledagger.presentation.sample.SampleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Все фрагменты добавляются сюда
 */
@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun sampleFragment(): SampleFragment
}