package com.example.vueloskotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vueloskotlin.ui.screens.HomeScreen
import com.example.vueloskotlin.ui.screens.LoginScreen
import com.example.vueloskotlin.ui.screens.RegisterScreen
import com.example.vueloskotlin.ui.screens.WelcomeScreen
import com.example.vueloskotlin.ui.theme.VuelosKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VuelosKotlinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VuelosAppNavigation()
                }
            }
        }
    }
}

@Composable
fun VuelosAppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(
                onLoginClick = { navController.navigate("login") },
                onGuestClick = { navController.navigate("home") }
            )
        }
        composable("login") {
            LoginScreen(
                onLoginSuccess = { 
                    navController.navigate("home") {
                        popUpTo("welcome") { inclusive = true }
                    }
                },
                onCreateAccountClick = { navController.navigate("register") },
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("register") {
            RegisterScreen(
                onRegisterSuccess = { 
                    navController.navigate("home") {
                        popUpTo("welcome") { inclusive = true }
                    }
                },
                onBackToLogin = { navController.popBackStack() },
                onBackToWelcome = {
                    navController.navigate("welcome") {
                        popUpTo("welcome") { inclusive = true }
                    }
                }
            )
        }
        composable("home") {
            HomeScreen()
        }
    }
}
