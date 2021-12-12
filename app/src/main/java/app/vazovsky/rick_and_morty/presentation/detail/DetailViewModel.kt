package app.vazovsky.rick_and_morty.presentation.detail

import androidx.lifecycle.ViewModel
import app.vazovsky.rick_and_morty.data.repository.ApiRepository
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val repository: ApiRepository
) : ViewModel() {
}