package app.vazovsky.rick_and_morty.presentation.episode.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import app.vazovsky.rick_and_morty.databinding.ItemEpisodeBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class EpisodeViewHolder(
    private val parent: ViewGroup,
    private val onItemClick: (EpisodeEntity) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_episode, parent, false)
) {
    private val binding by viewBinding(ItemEpisodeBinding::bind)
    fun bind(episode: EpisodeEntity) {
        itemView.setOnClickListener { onItemClick(episode) }
        binding.apply {
            textViewEpisodeIdAndName.text = "#${episode.id} ${episode.name}"
            textViewEpisodeAirDate.text = episode.airDate
        }
    }
}