package app.vazovsky.rick_and_morty.data.db.entity.converters

import androidx.room.TypeConverter
import app.vazovsky.rick_and_morty.data.model.responses.Origin

class OriginConverter {
    @TypeConverter
    fun fromOrigin(origin: Origin): String {
        return buildString {

        }
    }

    @TypeConverter
    fun toOrigin(origin: String): Origin {
        return Origin(null, null)
    }
}