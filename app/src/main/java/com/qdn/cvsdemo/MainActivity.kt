package com.qdn.cvsdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.qdn.cvsdemo.ui.screens.DetailScreen
import com.qdn.cvsdemo.ui.screens.SearchScreen
import com.qdn.cvsdemo.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val navController = rememberNavController()
            val sharedViewModel: SharedViewModel = hiltViewModel()

            AppTheme {
                NavHost(navController, startDestination = "search") {
                    composable("search") {
                        SearchScreen( { image ->
                            sharedViewModel.selectedImage = image
                            navController.navigate("detail")
                        })
                    }

                    composable(route = "detail") {
                        val image = sharedViewModel.selectedImage

                        if (image != null) {
                            DetailScreen(image) {
                                navController.popBackStack()
                            }
                        } else {
                            LaunchedEffect(Unit) {
                                Toast.makeText(
                                    context,
                                    "Error: No image data found.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}