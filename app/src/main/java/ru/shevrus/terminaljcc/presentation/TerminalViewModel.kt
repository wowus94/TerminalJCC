package ru.shevrus.terminaljcc.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.shevrus.terminaljcc.data.ApiFactory

class TerminalViewModel : ViewModel() {

    private val apiService = ApiFactory.apiService

    private var lastState: TerminalScreenState = TerminalScreenState.Initial

    private val _state = MutableStateFlow<TerminalScreenState>(TerminalScreenState.Initial)
    val state = _state.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _state.value = lastState
    }

    init {
        loadBarList()
    }

    fun loadBarList(timeFrame: TimeFrame = TimeFrame.HOUR_1) {
        lastState = _state.value
        _state.value = TerminalScreenState.Loading
        viewModelScope.launch(exceptionHandler) {
            val barList = apiService.loadBars(timeFrame.value).barList
            _state.value = TerminalScreenState.Content(barList = barList, timeFrame = timeFrame)
        }
    }
}