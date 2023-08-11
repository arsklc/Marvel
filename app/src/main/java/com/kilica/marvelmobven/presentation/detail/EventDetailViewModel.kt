package com.kilica.marvelmobven.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kilica.marvelmobven.domain.use_case.get_event_detail.GetEventDetailUseCase
import com.kilica.marvelmobven.util.Constants.ID
import com.kilica.marvelmobven.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventDetailViewModel @Inject constructor(
    private val getEventDetailUseCase: GetEventDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(EventDetailState())
    val state: State<EventDetailState> = _state

    init {
        savedStateHandle.get<String>(ID)?.let {
            getEventDetail(it)
        }
    }


    private fun getEventDetail(id: String) {
        viewModelScope.launch {
            getEventDetailUseCase.executeGetEventDetail(id = id).collect {
                when (it) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(event = it.data, isLoading = false)
                    }

                    is Resource.Error -> {
                        _state.value =
                            _state.value.copy(error = it.message ?: "", isLoading = false)
                    }

                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                }
            }
        }
    }
    fun clear() {
        _state.value = EventDetailState()
    }
}