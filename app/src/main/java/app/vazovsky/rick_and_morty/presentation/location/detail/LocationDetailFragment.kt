package app.vazovsky.rick_and_morty.presentation.location.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.CharacterEntity
import app.vazovsky.rick_and_morty.data.db.entity.EpisodeEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.databinding.FragmentLocationDetailBinding
import app.vazovsky.rick_and_morty.presentation.CustomViewFlipper.Companion.STATE_DATA
import app.vazovsky.rick_and_morty.presentation.ItemDecorator
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import javax.inject.Inject

class LocationDetailFragment : BaseFragment(R.layout.fragment_location_detail) {
    private val viewModel: LocationDetailViewModel by appViewModels()
    private val binding by viewBinding(FragmentLocationDetailBinding::bind)

    private val args by navArgs<LocationDetailFragmentArgs>()
    private val location by lazy { args.location }

    @Inject lateinit var residentAdapter: LocationResidentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadResidents(location.residents)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
        configureViews()
        setViewModelObservers()
    }

    private fun setViewModelObservers() = with(binding) {
        viewModel.stateCharacterLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipper.setState(state)
            if (customViewFlipper.displayedChild == STATE_DATA) {
                val items = (state as State.Data<List<CharacterEntity>>).data
                residentAdapter.setItems(items)
            }
        }
    }

    private fun configureViews() = with(binding) {
        toolbar.title = location.name
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        textViewLocationId.text = "id: #${location.id}"
        textViewLocationType.text = "type: ${location.type}"
        textViewLocationDimension.text = "dimension: ${location.dimension}"
    }

    private fun configureRecyclerView() {
        residentAdapter.onItemClick = { resident ->
            findNavController().navigate(
                LocationDetailFragmentDirections.actionLocationDetailFragmentToCharacterDetailFragment(resident)
            )
        }
        binding.recyclerViewResidents.apply {
            addItemDecoration(ItemDecorator())
            adapter = residentAdapter
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }
    }
}