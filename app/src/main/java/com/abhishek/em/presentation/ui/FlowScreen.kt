package com.abhishek.em.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abhishek.em.presentation.viewmodel.FlowViewModel
import com.abhishek.em.presentation.viewmodel.GreetingViewModel
import kotlin.math.exp

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FlowScreen(
    viewModel: FlowViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Red), contentAlignment = Alignment.Center) {
        Text("🏠 Flow Screen")

        
    }
}
