package ru.shevrus.terminaljcc.presentation

import ru.shevrus.terminaljcc.data.Bar

sealed class TerminalScreenState {

    data object Initial : TerminalScreenState()

    data object Loading : TerminalScreenState()

    data class Content(val barList: List<Bar>, val timeFrame: TimeFrame) : TerminalScreenState()
}