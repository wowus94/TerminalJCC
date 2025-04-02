package ru.shevrus.terminaljcc.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.shevrus.terminaljcc.ui.theme.TerminalJCCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerminalJCCTheme {
                Terminal()
            }
        }
    }
}
