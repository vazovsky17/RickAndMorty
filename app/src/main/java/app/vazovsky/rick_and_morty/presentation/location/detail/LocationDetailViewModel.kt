package app.vazovsky.rick_and_morty.presentation.location.detail

import androidx.lifecycle.ViewModel
import app.vazovsky.rick_and_morty.data.repository.LocationRepository
import javax.inject.Inject

class LocationDetailViewModel @Inject constructor(
    private val repository: LocationRepository
) : ViewModel() {
}