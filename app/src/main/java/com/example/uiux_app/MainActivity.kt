package com.example.uiux_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.uiux_app.ui.theme.Uiux_appTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Uiux_appTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "login") {
                    composable("login") { LoginScreen(navController) }
                    composable("timer") { TimerScreen(navController) }
                    composable("clock") { ClockScreen(navController) }
                    composable("congrats") { CongratsScreen(navController) }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Log In",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Log in to your account",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        // Space between text and fields
        Spacer(modifier = Modifier.height(20.dp))

        // Username or email field
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("User name or email") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        // Password field
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Password") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { /* Handle done action */ })
        )

        // Space between password field and "Remember me"
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = {}
            )
            Text(text = "Remember Me")
        }

        // Space between "Remember me" and "Forgot Password?"
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Forgot Password?",
            color = MaterialTheme.colorScheme.secondary
        )

        // Space between "Forgot Password?" and "Log In" button
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("timer") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Log In")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimerScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Tu temporizador circular
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(200.dp)) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                // Dibuja el círculo del temporizador aquí
                drawCircle(
                    color = Color.Green,
                    style = Stroke(width = 8.dp.toPx())
                )
            }
            Text("01:00", style = MaterialTheme.typography.headlineLarge)
        }
        Spacer(modifier = Modifier.height(32.dp))
        // Campo de entrada para la etiqueta
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Tag") },
            trailingIcon = { IconButton(onClick = { /* Icon action */ }) { Icon(Icons.Default.Search, contentDescription = null) } },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.LightGray
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("clock") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Text("Start")
        }
    }
}
@Composable
fun ClockScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA7E9AF))
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Tag Name",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
        )

        // Temporizador
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(200.dp)) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                // Dibuja el círculo del temporizador aquí
                drawCircle(
                    color = Color.Green,
                    style = Stroke(width = 8.dp.toPx())
                )
            }
            Text("01:00", style = MaterialTheme.typography.headlineLarge)
        }

        // Texto de sugerencias
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Tips or suggestions",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Supporting line text lorem ipsum dolor sit amet, consectetur.",
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            // Icono de candado
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Lock",
                modifier = Modifier
                    .size(48.dp)
                    .padding(top = 16.dp),
                tint = Color.Black
            )
            Button(
                onClick = { navController.navigate("congrats") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
            ) {
                Text("Finish")

            }
        }
    }
}
@Composable
fun CongratsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA7E9AF)), // Fondo verde claro
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Contenedor para la ilustración o ícono
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Gray.copy(alpha = 0.2f)), // Color gris claro para el fondo del cuadro
            contentAlignment = Alignment.Center
        ) {
            // Aquí iría la ilustración o ícono
            // Por ahora usaremos texto para representar el lugar del ícono
            Text(text = "1st", color = Color.DarkGray, fontSize = 24.sp)
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Texto de felicitación
        Text(
            text = "¡CONGRATS!",
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón de acción
        Button(
            onClick = { navController.navigate("timer") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1EB980) // Color verde del botón
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 64.dp)
                .height(50.dp)
        ) {
            Text(
                text = "Keep Busy",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}