package app.vazovsky.rick_and_morty.presentation.character.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import app.vazovsky.rick_and_morty.databinding.ItemEpisodeSimpleBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class CharacterEpisodeViewHolder(
    parent: ViewGroup,
    private val onItemClick: (EpisodeEntity) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_episode_simple, parent, false)
) {
    private val binding by viewBinding(ItemEpisodeSimpleBinding::bind)
    fun bind(episode: EpisodeEntity) {
        itemView.setOnClickListener { onItemClick(episode) }
        binding.textViewName.text = "#${episode.id} ${episode.name}"
    }
}