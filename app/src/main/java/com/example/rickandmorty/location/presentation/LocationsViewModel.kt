package com.example.rickandmorty.location.presentation

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.location.domain.repository.LocationsRepository
import com.example.rickandmorty.location.presentation.state.LocationsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LocationsViewModel(
    coroutineScope: CoroutineScope? = null,
) : ViewModel(),KoinComponent {
    private val repository: LocationsRepository by inject()

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state =  MutableStateFlow(LocationsState())
    val state get() = _state.asStateFlow()

    init {
        getLocations()
    }

    fun getLocations() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    isFailure = false,
                    isSuccess = false,
                )
            }

            repository.getLocations()
                .onSuccess {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        locationList = it.results,
                    )
                }
                .onFailure {
                    _state.value = _state.value.copy(
                        isFailure = true,
                        isLoading = false,
                    )
                }
        }
    }
}