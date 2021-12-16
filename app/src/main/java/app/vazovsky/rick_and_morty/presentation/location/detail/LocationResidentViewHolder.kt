package app.vazovsky.rick_and_morty.presentation.location.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.databinding.ItemSimpleBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class LocationResidentViewHolder(
    parent: ViewGroup,
    private val onItemClick: (CharacterEntity) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_simple, parent, false)
) {
    private val binding by viewBinding(ItemSimpleBinding::bind)
    fun bind(character: CharacterEntity) {
        itemView.setOnClickListener { onItemClick(character) }
        binding.textViewName.text = "#${character.id} ${character.name}"
    }
}