package app.vazovsky.rick_and_morty.presentation.location.list

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.db.entity.LocationEntity
import app.vazovsky.rick_and_morty.data.model.State
import app.vazovsky.rick_and_morty.databinding.FragmentLocationListBinding
import app.vazovsky.rick_and_morty.presentation.CustomViewFlipper.Companion.STATE_DATA
import app.vazovsky.rick_and_morty.presentation.ItemDecorator
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import javax.inject.Inject

class LocationListFragment : BaseFragment(R.layout.fragment_location_list) {
    private val viewModel: LocationListViewModel by appViewModels()
    private val binding by viewBinding(FragmentLocationListBinding::bind)
    @Inject lateinit var locationAdapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadLocations()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerView()
        configureToolbar()
        setViewModelObservers()

        binding.customViewFlipper.setOnErrorClickListener {
            viewModel.loadLocations()
        }
    }

    private fun setViewModelObservers() = with(viewModel) {
        stateLiveData.observe(viewLifecycleOwner) { state ->
            binding.apply {
                customViewFlipper.setState(state)
                if (customViewFlipper.displayedChild == STATE_DATA) {
                    val items = (state as State.Data<List<LocationEntity>>).data
                    locationAdapter.setItems(items)
                }
            }
        }
    }

    private fun configureRecyclerView() {
        locationAdapter.onItemClick = { location ->
            findNavController().navigate(
                LocationListFragmentDirections.actionLocationListFragmentToLocationDetailFragment(location)
            )
        }
        binding.recyclerView.apply {
            addItemDecoration(ItemDecorator())
            adapter = locationAdapter
        }
    }

    private fun configureToolbar() {
        binding.toolbar.apply {
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_characters -> {
                        findNavController().navigate(
                            LocationListFragmentDirections.actionLocationListFragmentToCharacterListFragment()
                        )
                        true
                    }
                    R.id.menu_episodes -> {
                        findNavController().navigate(
                            LocationListFragmentDirections.actionLocationListFragmentToEpisodeListFragment()
                        )
                        true
                    }
                    R.id.menu_search -> {
                        searchCharacter(it.actionView as SearchView)
                        true
                    }
                    R.id.menu_locations -> true
                    else -> false
                }
            }
        }
    }

    private fun searchCharacter(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchLocations(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchLocations(newText)
                return false
            }
        })
    }
}