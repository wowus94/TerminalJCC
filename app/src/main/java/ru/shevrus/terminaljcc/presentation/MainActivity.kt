package ru.shevrus.terminaljcc.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.shevrus.terminaljcc.ui.theme.TerminalJCCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerminalJCCTheme {
                val viewModel: TerminalViewModel = viewModel()
                val screenState = viewModel.state.collectAsState()
                when (val currentState = screenState.value) {
                    is TerminalScreenState.Content -> {
                        Terminal(currentState.barList)
                    }

                    is TerminalScreenState.Initial -> {
                        Log.d("MainActivity", "Error")
                    }
                }
            }
        }
    }
}
