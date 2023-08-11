package com.kilica.marvelmobven.presentation.homepage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kilica.marvelmobven.domain.use_case.get_events.GetEventUseCase
import com.kilica.marvelmobven.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val getEventUseCase: GetEventUseCase
    ) : ViewModel() {

        private val _state = mutableStateOf(EventsState())
        val state : State<EventsState> = _state

    init {
        viewModelScope.launch {
            getEvents(0)
        }
    }

        private suspend fun getEvents(offset : Int){
            getEventUseCase.executeGetEvents(offset = offset).collect {
                when(it){
                    is Resource.Success ->{
                        _state.value = EventsState(events = it.data ?: emptyList(), shouldShowLoading = false)
                    }
                    is Resource.Error ->{
                        _state.value = EventsState(error = it.message, shouldShowLoading = false)
                    }
                    else -> {}
            }
        }
    }

}