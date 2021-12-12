package app.vazovsky.rick_and_morty.presentation.character.detail

import androidx.lifecycle.ViewModel
import app.vazovsky.rick_and_morty.data.repository.CharacterRepository
import app.vazovsky.rick_and_morty.data.repository.LocationRepository
import javax.inject.Inject

class CharacterDetailViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
}