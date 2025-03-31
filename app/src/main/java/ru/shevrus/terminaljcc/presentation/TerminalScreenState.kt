package ru.shevrus.terminaljcc.presentation

import ru.shevrus.terminaljcc.data.Bar

sealed class TerminalScreenState {

    data object Initial : TerminalScreenState()

    data class Content(val barList: List<Bar>) : TerminalScreenState()
}