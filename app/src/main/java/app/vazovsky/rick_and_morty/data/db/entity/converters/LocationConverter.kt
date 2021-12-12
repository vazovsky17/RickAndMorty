package app.vazovsky.rick_and_morty.data.db.entity.converters

import androidx.room.TypeConverter
import app.vazovsky.rick_and_morty.data.model.responses.Location

class LocationConverter {
    @TypeConverter
    fun fromLocation(location: Location): String {
        return buildString {

        }
    }

    @TypeConverter
    fun toLocation(location: String): Location {
        return Location(null, null)
    }
}