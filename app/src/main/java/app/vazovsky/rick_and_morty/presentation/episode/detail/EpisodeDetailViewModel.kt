package app.vazovsky.rick_and_morty.presentation.episode.detail

import androidx.lifecycle.ViewModel
import app.vazovsky.rick_and_morty.data.repository.CharacterRepository
import app.vazovsky.rick_and_morty.data.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeDetailViewModel @Inject constructor(
    private val repository: EpisodeRepository
) : ViewModel() {
}