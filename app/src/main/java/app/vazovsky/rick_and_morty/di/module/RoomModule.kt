package app.vazovsky.rick_and_morty.di.module

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import app.vazovsky.rick_and_morty.data.db.AppDatabase
import app.vazovsky.rick_and_morty.data.db.dao.CharacterDao
import app.vazovsky.rick_and_morty.data.db.dao.EpisodeDao
import app.vazovsky.rick_and_morty.data.db.dao.LocationDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideRoomDatabases(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }
}