package com.essycynthia.mobcv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.essycynthia.mobcv.ui.theme.EditableScreen
import com.essycynthia.mobcv.ui.theme.MobCvTheme
import com.essycynthia.mobcv.ui.theme.util.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobCvTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sharedViewModel = viewModel<CvViewModel>()
                    val navController  = rememberNavController()
                    NavHost(navController = navController, startDestination =Screen.CvScreen.route ){
                        composable(
                            route = Screen.CvScreen.route
                        ){
                            CvScreen(navController = navController,viewModel = sharedViewModel)
                        }
                        composable(
                            route = Screen.EditableScreen.route
                        ){
                            EditableScreen(navController = navController,viewModel = sharedViewModel)
                        }
                    }

                }
            }
        }
    }
}

