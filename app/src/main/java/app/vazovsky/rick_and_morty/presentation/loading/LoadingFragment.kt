package app.vazovsky.rick_and_morty.presentation.loading

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.data.model.StateDownloadProgress
import app.vazovsky.rick_and_morty.databinding.FragmentLoadingBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class LoadingFragment : BaseFragment(R.layout.fragment_loading) {
    private val binding by viewBinding(FragmentLoadingBinding::bind)
    private val viewModel: LoadingViewModel by appViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModelObservers()
        binding.buttonReload.setOnClickListener {
            viewModel.loadData()
        }
    }

    private fun setViewModelObservers() {
        setCharactersObserver()
        setEpisodesObserver()
        setLocationsObservers()
    }

    private fun setCharactersObserver() = with(binding) {
        viewModel.characterProgressLiveData.observe(viewLifecycleOwner) { state ->
            if (state is StateDownloadProgress.Progress) {
                progressBarCharacters.progress = state.progress
                textViewProgressCharacters.text = "Loading Characters ${state.progress}%"
            } else {
                buttonReload.visibility = View.GONE
            }
            checkLoaded()
        }
    }

    private fun setEpisodesObserver() = with(binding) {
        viewModel.episodeProgressLiveData.observe(viewLifecycleOwner) { state ->
            if (state is StateDownloadProgress.Progress) {
                progressBarEpisodes.progress = state.progress
                textViewProgressEpisodes.text = "Loading Episodes ${state.progress}%"
            } else {
                buttonReload.visibility = View.GONE
            }
            checkLoaded()
        }
    }

    private fun setLocationsObservers() = with(binding) {
        viewModel.locationProgressLiveData.observe(viewLifecycleOwner) { state ->
            if (state is StateDownloadProgress.Progress) {
                progressBarLocations.progress = state.progress
                textViewProgressLocations.text = "Loading Locations ${state.progress}"
            } else {
                buttonReload.visibility = View.GONE
            }
            checkLoaded()
        }
    }


    private fun checkLoaded() = with(binding) {
        if (progressBarCharacters.progress >= 100
            && progressBarEpisodes.progress >= 100
            && progressBarLocations.progress >= 100
        ) {
            findNavController().navigate(
                LoadingFragmentDirections.actionLoadingFragmentToCharacterListFragment()
            )
        }
    }
}