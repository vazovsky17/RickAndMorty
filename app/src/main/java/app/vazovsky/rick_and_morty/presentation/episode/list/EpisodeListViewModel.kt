package app.vazovsky.rick_and_morty.presentation.episode.list

import androidx.lifecycle.ViewModel
import app.vazovsky.rick_and_morty.data.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeListViewModel @Inject constructor(
    private val repository: EpisodeRepository
) : ViewModel() {
}