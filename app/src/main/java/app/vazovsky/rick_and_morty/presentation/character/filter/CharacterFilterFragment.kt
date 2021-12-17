package app.vazovsky.rick_and_morty.presentation.character.filter

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.databinding.FragmentCharacterFilterBinding
import app.vazovsky.rick_and_morty.presentation.CustomViewFlipper
import app.vazovsky.rick_and_morty.presentation.CustomViewFlipper.Companion.STATE_DATA
import app.vazovsky.rick_and_morty.presentation.ItemDecorator
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import javax.inject.Inject

class CharacterFilterFragment : BaseFragment(R.layout.fragment_character_filter) {
    private val viewModel: CharacterFilterViewModel by appViewModels()
    private val binding by viewBinding(FragmentCharacterFilterBinding::bind)

    @Inject lateinit var statusAdapter: FilterAdapter
    @Inject lateinit var speciesAdapter: FilterAdapter
    @Inject lateinit var typeAdapter: FilterAdapter
    @Inject lateinit var genderAdapter: FilterAdapter
    @Inject lateinit var originAdapter: FilterAdapter
    @Inject lateinit var locationAdapter: FilterAdapter
    @Inject lateinit var episodesAdapter: FilterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadStatusList()
        viewModel.loadSpeciesList()
        viewModel.loadTypeList()
        viewModel.loadGenderList()
        viewModel.loadLocationList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerViews()

        binding.buttonApply.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun configureRecyclerViews() {
        configureStatus()
        configureSpecies()
        configureType()
        configureGender()
        configureOrigin()
        configureLocation()
        configureEpisodes()
    }

    private fun configureStatus() = with(binding) {
        recyclerViewFilterStatus.adapter = statusAdapter
        viewModel.stateStatusLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipperStatus.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<String>>).data
                    statusAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureSpecies() = with(binding) {
        recyclerViewFilterSpecies.adapter = speciesAdapter
        viewModel.stateSpeciesLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipperSpecies.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<String>>).data
                    speciesAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureType() = with(binding) {
        recyclerViewFilterType.adapter = typeAdapter
        viewModel.stateTypeLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipperType.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<String>>).data
                    typeAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureGender() = with(binding) {
        recyclerViewFilterGender.adapter = genderAdapter
        viewModel.stateGenderLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipperGender.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<String>>).data
                    genderAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureOrigin() = with(binding) {
        recyclerViewFilterOrigin.adapter = originAdapter
        viewModel.stateLocationLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipperOrigin.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<String>>).data
                    originAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureLocation() = with(binding) {
        recyclerViewFilterLocation.adapter = locationAdapter
        viewModel.stateLocationLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipperLocation.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<String>>).data
                    locationAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureEpisodes() = with(binding.recyclerViewFilterEpisodes) {
        addItemDecoration(ItemDecorator())
        adapter = episodesAdapter
    }
}