package app.vazovsky.sampledagger.di.module

import app.vazovsky.sampledagger.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Все Активити добавляются сюда
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}