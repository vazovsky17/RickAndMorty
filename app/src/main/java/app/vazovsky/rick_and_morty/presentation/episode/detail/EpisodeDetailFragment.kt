package app.vazovsky.rick_and_morty.presentation.episode.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.FragmentEpisodeDetailBinding
import app.vazovsky.rick_and_morty.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding

class EpisodeDetailFragment : BaseFragment(R.layout.fragment_episode_detail) {
    private val viewModel: EpisodeDetailViewModel by appViewModels()
    private val binding by viewBinding(FragmentEpisodeDetailBinding::bind)

    private val args by navArgs<EpisodeDetailFragmentArgs>()
    private val episode by lazy { args.episode }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbar.title = episode.name
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            textViewEpisodeId.text = "id: #${episode.id}"
            textViewEpisodeEpisodeCode.text = "episode: ${episode.episode}"
            textViewEpisodeAirDate.text = "air date: ${episode.airDate}"
            textViewEpisodeCharacters.text = "characters:\n${episode.characters}"
        }
    }
}