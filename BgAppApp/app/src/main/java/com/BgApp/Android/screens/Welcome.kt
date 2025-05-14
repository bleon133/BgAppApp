package com.BgApp.Android.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.BgApp.Android.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.BgApp.Android.ui.theme.BgAppTheme

@Composable
fun SplashScreen(navController: NavController) {
    var visible by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        visible = true
        delay(2000L)
        navController.navigate("welcome") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF0B495E),
                            Color(0xFF1581A4)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(initialAlpha = 0f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bgapp_logo),
                    contentDescription = "Logo BGApp",
                    modifier = Modifier
                        .padding(38.dp)
                        .fillMaxSize(1f)
                )
            }
        }
    }
}

@Composable
fun SplashScreenPreview() {
    BgAppTheme {
        val navController = rememberNavController()
        SplashScreen(navController = navController)
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StaticSplashScreenPreview() {
    BgAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF0B495E),
                            Color(0xFF1581A4)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.bgapp_logo),
                contentDescription = "Logo BGApp",
                modifier = Modifier
                    .padding(38.dp)
                    .fillMaxSize(1f)
            )
        }
    }
}
