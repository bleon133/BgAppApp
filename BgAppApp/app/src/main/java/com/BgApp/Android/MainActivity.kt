package com.BgApp.Android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.BgApp.Android.screens.LoginScreen
import com.BgApp.Android.screens.RegisterScreen
import com.BgApp.Android.screens.WelcomeScreen
import com.BgApp.Android.screens.SplashScreen
import com.BgApp.Android.ui.theme.BgAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BgAppTheme {
                // Navegación
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {
                    composable("splash") { SplashScreen(navController = navController) }
                    composable("login") { LoginScreen(navController = navController) }
                    composable("register") { RegisterScreen(navController = navController) }
                    composable("welcome") { WelcomeScreen(navController = navController) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BgAppTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "splash") {
            composable("splash") { SplashScreen(navController) }
            composable("login") { LoginScreen(navController) }
            composable("register") { RegisterScreen(navController) }
            composable("welcome") { WelcomeScreen(navController) }
        }
    }
}
