package com.diegochancafe.curiosity.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.diegochancafe.curiosity.view.theme.CuriosityTheme
import com.diegochancafe.curiosity.view.screen.PhotoListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //--
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuriosityTheme {
                PhotoListScreen()
            }
        }
    }
}
