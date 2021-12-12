package app.vazovsky.rick_and_morty.presentation.episode.detail

import android.os.Bundle
import android.view.View
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentEpisodeDetailBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class EpisodeDetailFragment : BaseFragment(R.layout.fragment_episode_detail) {
    private val viewModel: EpisodeDetailViewModel by appViewModels()
    private val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}