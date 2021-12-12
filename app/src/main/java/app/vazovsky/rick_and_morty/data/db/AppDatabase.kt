package app.vazovsky.rick_and_morty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.vazovsky.rick_and_morty.data.db.dao.CharacterDao
import app.vazovsky.rick_and_morty.data.db.dao.EpisodeDao
import app.vazovsky.rick_and_morty.data.db.dao.LocationDao
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import app.vazovsky.rick_and_morty.data.db.entity.LocationEntity
import app.vazovsky.rick_and_morty.data.db.entity.converters.ListStringConverter
import app.vazovsky.rick_and_morty.data.db.entity.converters.LocationConverter
import app.vazovsky.rick_and_morty.data.db.entity.converters.OriginConverter

@TypeConverters(
    ListStringConverter::class,
    LocationConverter::class,
    OriginConverter::class,
)
@Database(
    entities = [
        CharacterEntity::class,
        EpisodeEntity::class,
        LocationEntity::class
    ],
    version = AppDatabase.DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "app_database"
    }

    abstract fun getCharacterDao(): CharacterDao
    abstract fun getEpisodeDao(): EpisodeDao
    abstract fun getLocationDao(): LocationDao
}