package com.BgApp.Android.screens

import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.BgApp.Android.R
import com.BgApp.Android.ui.theme.BgAppTheme
import com.BgApp.Android.ui.theme.bgapp_theme_light_onPrimary
import com.BgApp.Android.ui.theme.bgapp_theme_light_primary
import com.BgApp.Android.ui.theme.bgapp_theme_light_primaryContainer

@Composable
fun LoginScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1581A4)),
        color = bgapp_theme_light_primaryContainer
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            MyCarousel()
            Spacer(modifier = Modifier.height(24.dp))
            LoginForm(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCarousel(){

    val carouselState = rememberCarouselState { 3 }

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
        HorizontalMultiBrowseCarousel(
            state = carouselState,
            preferredItemWidth = 300.dp,
            itemSpacing = 10.dp
        ) { page ->
            Box(modifier = Modifier.size(300.dp)) {
                Image(
                    painter = painterResource(
                        id = when (page) {
                            0 -> R.drawable.imagen_1
                            1 -> R.drawable.imagen_2
                            else -> R.drawable.bg_login
                        }
                    ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

}

@Composable
fun LoginForm(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(25.dp)
    ){
        Text(
            text = "Embárcate en una aventura con nosotros!",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF1581A4),
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = "Toggle password visibility")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF1581A4),
                unfocusedBorderColor = Color.Gray)
        )

        TextButton(onClick = { /* TODO */ }) {
            Text("¿Olvidaste tu contraseña?",
                color = bgapp_theme_light_onPrimary,
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { /* lógica de login */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = bgapp_theme_light_primary)
        ) {
            Text("Ingresar")
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
        onClick = { /* TODO */},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.googleicon),
                contentDescription = "Google icon",
                modifier = Modifier.size(20.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Ingresar con Google",
                color = bgapp_theme_light_onPrimary,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Text("¿No te has registrado aún?")
            Spacer(modifier = Modifier
            .width(4.dp))
            Text(
                text = "Regístrate ahora",
                color = bgapp_theme_light_onPrimary,
                modifier = Modifier.clickable { navController.navigate("register") },
                fontWeight = FontWeight.SemiBold
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController() // Crear un NavController para el preview
    BgAppTheme {
        LoginScreen(navController = navController) // Pasamos el NavController al LoginScreen
    }
}
