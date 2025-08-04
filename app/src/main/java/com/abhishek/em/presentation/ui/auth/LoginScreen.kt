package com.abhishek.em.presentation.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.abhishek.em.theme.Gray400

@Composable
fun LoginScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("Sahil") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
//    val viewModel: GreetingViewModel = hiltViewModel()

    Scaffold(
        containerColor = Gray400
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            Arrangement.Center
        ) {
            Box {

            }

            Box {

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