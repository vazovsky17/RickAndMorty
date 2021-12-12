package app.vazovsky.rick_and_morty.presentation.episode.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import javax.inject.Inject

class EpisodeAdapter @Inject constructor() : RecyclerView.Adapter<EpisodeViewHolder>() {

    private val items = mutableListOf<EpisodeEntity>()
    lateinit var onItemClick: (EpisodeEntity) -> Unit

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EpisodeViewHolder(parent, onItemClick)
    override fun getItemCount() = items.size

    fun setItems(items: List<EpisodeEntity>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

}