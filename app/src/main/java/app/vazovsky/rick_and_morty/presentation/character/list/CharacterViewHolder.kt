package app.vazovsky.rick_and_morty.presentation.character.list

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.databinding.ItemCharacterBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide

class CharacterViewHolder(
    parent: ViewGroup,
    private val onItemClick: (CharacterEntity) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
) {
    private val binding by viewBinding(ItemCharacterBinding::bind)
    fun bind(character: CharacterEntity) {
        itemView.setOnClickListener { onItemClick(character) }
        binding.apply {
            Glide.with(itemView.context)
                .asBitmap()
                .load(character.image)
                .circleCrop()
                .placeholder(R.drawable.placeholder)
                .into(imageViewCharacterImage)
            textViewCharacterId.text = "#${character.id}"
            textViewCharacterName.text = character.name
            textViewCharacterStatus.text = character.status
            textViewCharacterStatus.setTextColor(character.getStatusColor())
        }
    }
}