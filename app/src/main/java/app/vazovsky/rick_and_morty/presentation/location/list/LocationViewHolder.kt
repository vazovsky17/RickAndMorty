package app.vazovsky.rick_and_morty.presentation.location.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.LocationEntity
import app.vazovsky.rick_and_morty.databinding.ItemCharacterBinding
import app.vazovsky.rick_and_morty.databinding.ItemLocationBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class LocationViewHolder(
    private val parent: ViewGroup,
    private val onItemClick: (LocationEntity) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_location, parent, false)
) {
    private val binding by viewBinding(ItemLocationBinding::bind)
    fun bind(location: LocationEntity) {
        itemView.setOnClickListener { onItemClick(location) }
    }
}