package app.vazovsky.rick_and_morty.data.db.entity.converters

import androidx.room.TypeConverter
import app.vazovsky.rick_and_morty.data.model.responses.Location
import com.google.gson.Gson

class LocationConverter {
    @TypeConverter
    fun fromLocation(location: Location): String {
        return Gson().toJson(location)
    }

    @TypeConverter
    fun toLocation(location: String): Location {
        return Gson().fromJson(location, Location::class.java)
    }
}