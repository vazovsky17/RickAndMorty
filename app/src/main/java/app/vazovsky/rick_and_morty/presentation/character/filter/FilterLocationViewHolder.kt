package app.vazovsky.rick_and_morty.presentation.character.filter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.model.filter.Filter
import app.vazovsky.rick_and_morty.data.model.filter.FilterLocation
import app.vazovsky.rick_and_morty.databinding.ItemCheckboxBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class FilterLocationViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_checkbox, parent, false)
) {
    private val binding by viewBinding(ItemCheckboxBinding::bind)
    fun bind(filter: FilterLocation) = with(binding) {
        checkbox.text = filter.location.name
        checkbox.setOnClickListener {
            filter.checked = checkbox.isChecked
        }
    }
}