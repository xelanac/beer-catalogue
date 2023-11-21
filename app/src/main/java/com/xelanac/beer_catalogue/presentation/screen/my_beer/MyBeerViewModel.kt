package com.xelanac.beer_catalogue.presentation.screen.my_beer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xelanac.beer_catalogue.common.Resource
import com.xelanac.beer_catalogue.domain.use_case.GetRandomBeerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MyBeerViewModel @Inject constructor(
    private val getRandomBeerUseCase: GetRandomBeerUseCase
): ViewModel() {
    private val _state = mutableStateOf(MyBeerState())
    val state: State<MyBeerState> = _state

    fun getMyBeer() {
        getRandomBeerUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = MyBeerState(
                        beer = result.data
                    )
                }
                is Resource.Error -> {
                    _state.value = MyBeerState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MyBeerState(
                        isLoading = true
                    )
                }

            }
        }.launchIn(viewModelScope)
    }
}