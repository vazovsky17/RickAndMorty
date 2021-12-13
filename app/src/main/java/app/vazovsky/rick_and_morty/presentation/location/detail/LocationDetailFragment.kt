package app.vazovsky.rick_and_morty.presentation.location.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentLocationDetailBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class LocationDetailFragment : BaseFragment(R.layout.fragment_location_detail) {
    private val viewModel: LocationDetailViewModel by appViewModels()
    private val binding by viewBinding(FragmentLocationDetailBinding::bind)

    private val args by navArgs<LocationDetailFragmentArgs>()
    private val location by lazy { args.location }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbar.title = location.name
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            textViewLocationId.text = "id: #${location.id}"
            textViewLocationType.text = "type: ${location.type}"
            textViewLocationDimension.text = "dimension: ${location.dimension}"
            textViewLocationResidents.text = "residents:\n${location.residents}"
        }
    }
}