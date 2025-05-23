package com.example.composeguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.module1.Module1Screen
import com.example.module2.Module2Screen
import com.example.module3.Module3Screen
import com.example.module4.Module4Screen
import com.example.module5.Module5Screen
import com.example.module6.Module6Screen
import com.example.module7.Module7Screen
import com.example.module8.Module8Screen
import com.example.module9.Module9Screen
import com.example.module10.Module10Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeGuideTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "module1") {
        composable("module1") { Module1Screen { navController.navigate("module2") } }
        composable("module2") { Module2Screen { navController.navigate("module3") } }
        composable("module3") { Module3Screen { navController.navigate("module4") } }
        composable("module4") { Module4Screen { navController.navigate("module5") } }
        composable("module5") { Module5Screen { navController.navigate("module6") } }
        composable("module6") { Module6Screen { navController.navigate("module7") } }
        composable("module7") { Module7Screen { navController.navigate("module8") } }
        composable("module8") { Module8Screen { navController.navigate("module9") } }
        composable("module9") { Module9Screen { navController.navigate("module10") } }
        composable("module10") { Module10Screen { } }
    }
}
