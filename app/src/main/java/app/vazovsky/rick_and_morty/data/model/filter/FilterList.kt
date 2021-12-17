package app.vazovsky.rick_and_morty.data.model.filter

import android.os.Parcelable
import app.vazovsky.rick_and_morty.data.db.entity.Location
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilterList(
    val statusList: List<String>,
    val speciesList: List<String>,
    val typeList: List<String>,
    val genderList: List<String>,
    val originList: List<Location>,
    val locationList: List<Location>
) : Parcelable