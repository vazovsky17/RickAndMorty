package app.vazovsky.rick_and_morty.presentation.location.list

import androidx.lifecycle.ViewModel
import app.vazovsky.rick_and_morty.data.repository.LocationRepository
import javax.inject.Inject

class LocationListViewModel @Inject constructor(
    private val repository: LocationRepository
) : ViewModel() {
}