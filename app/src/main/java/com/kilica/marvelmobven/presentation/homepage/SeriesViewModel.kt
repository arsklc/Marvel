package com.kilica.marvelmobven.presentation.homepage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kilica.marvelmobven.domain.use_case.get_series.GetSeriesUseCase
import com.kilica.marvelmobven.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getSeriesUseCase: GetSeriesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(SeriesState())
    val state : State<SeriesState> = _state

    init {
        viewModelScope.launch {
            getSeries(0)
        }
    }

    private suspend fun getSeries(offset : Int){
        getSeriesUseCase.executeGetSeries(offset = offset).collect {
            when(it){
                is Resource.Success ->{
                    _state.value = SeriesState(series = it.data ?: emptyList(), shouldShowLoading = false)
                }
                is Resource.Error ->{
                    _state.value = SeriesState(error = it.message, shouldShowLoading = false)
                }
                else -> {}
            }
        }
    }

}