package com.abhishek.em.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abhishek.em.presentation.viewmodel.GreetingViewModel
import kotlin.math.exp

@Composable
fun WelcomeScreen(
    viewModel: GreetingViewModel = hiltViewModel()
) {
   /* Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome Guest",
            style = MaterialTheme.typography.headlineLarge
        )
    }*/
    LazyColumn {
        items(viewModel.expenses) { expense ->
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = expense.amount.toString(), style = MaterialTheme.typography.titleLarge)
                Text(text = expense.description, style = MaterialTheme.typography.bodyMedium)
                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Red), contentAlignment = Alignment.Center) {
        Text("🏠 Home Screen")
    }
}

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Green), contentAlignment = Alignment.Center) {
        Text("👤 Profile Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue), contentAlignment = Alignment.Center) {
        Text("⚙️ Settings Screen")
    }
}