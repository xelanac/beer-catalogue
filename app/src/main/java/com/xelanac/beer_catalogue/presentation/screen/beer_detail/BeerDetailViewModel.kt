package com.xelanac.beer_catalogue.presentation.screen.beer_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xelanac.beer_catalogue.common.Resource
import com.xelanac.beer_catalogue.domain.use_case.GetBeerDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BeerDetailViewModel @Inject constructor(
    private val getBeerDetailUseCase: GetBeerDetailUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(BeerDetailState())
    val state: State<BeerDetailState> = _state

    init {
        savedStateHandle.get<Int>("beerId")?.let { beerId ->
            getMyBeer(beerId)
        }
    }

    private fun getMyBeer(beerId: Int) {
        getBeerDetailUseCase(beerId = beerId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = BeerDetailState(
                        beer = result.data
                    )
                }
                is Resource.Error -> {
                    _state.value = BeerDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = BeerDetailState(
                        isLoading = true
                    )
                }

            }
        }.launchIn(viewModelScope)
    }
}