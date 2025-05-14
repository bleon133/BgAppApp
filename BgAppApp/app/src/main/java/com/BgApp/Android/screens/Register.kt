package com.BgApp.Android.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.BgApp.Android.R
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.BgApp.Android.ui.theme.BgAppTheme
import com.BgApp.Android.ui.theme.bgapp_theme_light_onPrimary
import com.BgApp.Android.ui.theme.bgapp_theme_light_primaryContainer

@Composable
fun TextFieldWithLabel(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            placeholder = { Text(placeholder) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF1581A4),
                unfocusedBorderColor = Color.Gray
            )
        )
    }
}

@Composable
fun PasswordTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isVisible: Boolean,
    onVisibilityChange: (Boolean) -> Unit,
    placeholder: String,
    ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold  ),
            color = MaterialTheme.colorScheme.onSurface
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF1581A4),
                unfocusedBorderColor = Color.Gray
            ),
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (isVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                IconButton(onClick = { onVisibilityChange(!isVisible) }) {
                    Icon(imageVector = icon, contentDescription = null)
                }
            }
        )
    }
}

@Composable
fun RegisterScreen(navController: NavController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var acceptedTerms by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1581A4)),
        color = MaterialTheme.colorScheme.background
    )

    {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bg_register),
                    contentDescription = "Imagen Login",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                IconButton(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopStart)
                        .background(Color.White.copy(alpha = 0.7f), shape = CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(38.dp))

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Descubre y explora")
                    }
                    append(" a través de Colombia!")
                },
                style = MaterialTheme.typography.titleMedium.copy(
                    lineHeight = 22.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Crea una cuenta y permite que te acompañemos en tu aventura por Colombia",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextFieldWithLabel("Nombre", firstName, { firstName = it }, "Escribe tu nombre")
            TextFieldWithLabel("Apellidos", lastName, { lastName = it }, "Escribe tu apellido")
            TextFieldWithLabel("Email", email, { email = it }, "Escribe tu correo electrónico")
            TextFieldWithLabel("Nombre de usuario", username, { username = it }, "Escribe tu nombre de usuario")

            PasswordTextField(
                label = "Contraseña",
                value = password,
                onValueChange = { password = it },
                isVisible = passwordVisible,
                onVisibilityChange = { passwordVisible = it },
                "Crea una contraseña"

            )

            PasswordTextField(
                label = "Confirma la contraseña",
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                isVisible = confirmPasswordVisible,
                onVisibilityChange = { confirmPasswordVisible = it },
                "Confirma la contraseña"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.Top
            ) {
                Checkbox(
                    checked = acceptedTerms,
                    onCheckedChange = { acceptedTerms = it }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    buildAnnotatedString {
                        append("Al ingresar a la aplicación aceptas los ")
                        withStyle(style = SpanStyle(color = bgapp_theme_light_onPrimary, fontWeight = FontWeight.SemiBold)) {
                            append("términos y condiciones")
                        }
                        append(" de uso y la ")
                        withStyle(style = SpanStyle(color = bgapp_theme_light_onPrimary, fontWeight = FontWeight.SemiBold)) {
                            append("Política de privacidad.")
                        }
                    },
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f),

                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* TODO: lógica de registro */ },
                enabled = acceptedTerms,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),

            ) {
                Text("Crear cuenta")
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(
    name = "RegisterScreenPreview",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RegisterScreenPreview() {
    val navController = rememberNavController()
    BgAppTheme {
        RegisterScreen(navController = navController)
    }
}