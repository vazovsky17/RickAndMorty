package app.vazovsky.rick_and_morty.data.db.entity.converters

import androidx.room.TypeConverter
import app.vazovsky.rick_and_morty.data.db.entity.Origin
import com.google.gson.Gson

class OriginConverter {
    @TypeConverter
    fun fromOrigin(origin: Origin): String {
        return Gson().toJson(origin)
    }

    @TypeConverter
    fun toOrigin(origin: String): Origin {
        return Gson().fromJson(origin, Origin::class.java)
    }
}