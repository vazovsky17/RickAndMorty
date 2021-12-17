package app.vazovsky.rick_and_morty.presentation.character.filter

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.model.filter.Filter
import app.vazovsky.rick_and_morty.data.model.filter.FilterList
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.data.model.filter.FilterLocation
import app.vazovsky.rick_and_morty.databinding.FragmentCharacterFilterBinding
import app.vazovsky.rick_and_morty.presentation.CustomViewFlipper.Companion.STATE_DATA
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import app.vazovsky.rick_and_morty.presentation.character.list.CharacterListFragment.Companion.BUNDLE_FILTER
import app.vazovsky.rick_and_morty.presentation.character.list.CharacterListFragment.Companion.RESULT_FILTER
import by.kirich1409.viewbindingdelegate.viewBinding
import javax.inject.Inject

class CharacterFilterFragment : BaseFragment(R.layout.fragment_character_filter) {
    private val viewModel: CharacterFilterViewModel by appViewModels()
    private val binding by viewBinding(FragmentCharacterFilterBinding::bind)

    @Inject lateinit var statusAdapter: FilterAdapter
    @Inject lateinit var speciesAdapter: FilterAdapter
    @Inject lateinit var typeAdapter: FilterAdapter
    @Inject lateinit var genderAdapter: FilterAdapter
    @Inject lateinit var originAdapter: FilterLocationAdapter
    @Inject lateinit var locationAdapter: FilterLocationAdapter

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
            getResults()
            findNavController().popBackStack()
        }
    }

    private fun getResults() {
        val statusList = statusAdapter.getCheckedItems()
        val speciesList = speciesAdapter.getCheckedItems()
        val typeList = typeAdapter.getCheckedItems()
        val genderList = genderAdapter.getCheckedItems()
        val originList = originAdapter.getCheckedItems()
        val locationList = locationAdapter.getCheckedItems()

        val filterList = FilterList(
            if (statusList.isEmpty()) statusAdapter.getAllItems() else statusList,
            if (speciesList.isEmpty()) speciesAdapter.getAllItems() else speciesList,
            if (typeList.isEmpty()) typeAdapter.getAllItems() else typeList,
            if (genderList.isEmpty()) genderAdapter.getAllItems() else genderList,
            if (originList.isEmpty()) originAdapter.getAllItems() else originList,
            if (locationList.isEmpty()) locationAdapter.getAllItems() else locationList,
        )
        setFragmentResult(
            RESULT_FILTER, bundleOf(
                BUNDLE_FILTER to filterList
            )
        )
    }

    private fun configureRecyclerViews() {
        configureStatus()
        configureSpecies()
        configureType()
        configureGender()
        configureOrigin()
        configureLocation()
    }

    private fun configureStatus() = with(binding.checkboxGroupStatus) {
        recyclerView.adapter = statusAdapter
        viewModel.stateStatusLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipper.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<Filter>>).data
                    statusAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureSpecies() = with(binding.checkboxGroupSpecies) {
        recyclerView.adapter = speciesAdapter
        viewModel.stateSpeciesLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipper.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<Filter>>).data
                    speciesAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureType() = with(binding.checkboxGroupType) {
        recyclerView.adapter = typeAdapter
        viewModel.stateTypeLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipper.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<Filter>>).data
                    typeAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureGender() = with(binding.checkboxGroupGender) {
        recyclerView.adapter = genderAdapter
        viewModel.stateGenderLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipper.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<Filter>>).data
                    genderAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureOrigin() = with(binding.checkboxGroupOrigin) {
        recyclerView.adapter = originAdapter
        viewModel.stateLocationLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipper.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<FilterLocation>>).data
                    originAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureLocation() = with(binding.checkboxGroupLocation) {
        recyclerView.adapter = locationAdapter
        viewModel.stateLocationLiveData.observe(viewLifecycleOwner) { state ->
            customViewFlipper.apply {
                setState(state)
                if (displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<FilterLocation>>).data
                    locationAdapter.setItems(items)
                }
            }
        }
    }

}