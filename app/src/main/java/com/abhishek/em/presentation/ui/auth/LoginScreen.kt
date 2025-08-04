package com.abhishek.em.presentation.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("Sahil") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
//    val viewModel: GreetingViewModel = hiltViewModel()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            Arrangement.Center
        ) {
            Box {
                Text(
                    "SAMPLE TEXT",
                    style = MaterialTheme.typography.displayLarge
                )
            }

            Box {
                Text(
                    "SAMPLE TEXT 2",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Box {
                Text(
                    "SAMPLE TEXT 3",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 42.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, apiLevel = 34)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}