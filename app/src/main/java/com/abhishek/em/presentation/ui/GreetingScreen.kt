package com.abhishek.em.presentation.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.abhishek.em.data.local.Expense
import com.abhishek.em.navigation.Routes
import com.abhishek.em.navigation.botttombar.BottomNavItem
import com.abhishek.em.presentation.viewmodel.GreetingViewModel
import kotlinx.coroutines.launch

@Composable
fun GreetingScreen(
    viewModel: GreetingViewModel = hiltViewModel(),
    navController: NavController
) {
        var amount by remember { mutableIntStateOf(0) }
        var description by remember { mutableStateOf("") }
        val greeting by viewModel.greeting.collectAsState()
        val counter by viewModel.sharedCounter.collectAsState()

        Column(
            modifier = Modifier
                .background(color = Color.Red)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Log.d("CounterScreen", "Recomposed with value: $counter")

            Box(
                contentAlignment = Alignment.Center
            ) {
                Text("⏱ Counter: $counter", fontSize = 24.sp)
            }

            OutlinedTextField(
                value = amount.toString(),
                onValueChange = { amount = it.toInt() },
                label = { Text("Enter expense amount") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Enter description") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    viewModel.saveExpense(
                        Expense(
                            amount = amount.toLong(),
                            description = description
                        )
                    )
//                    navController.navigate(Routes.Welcome) {
//                        launchSingleTop = true
//                        popUpTo(Routes.Greeting) {
//                            inclusive = false
//                        }
//                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Expense")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate(Routes.Welcome) {
                        popUpTo(Routes.Greeting) {
                            inclusive = false
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("List Expenses")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = greeting, style = MaterialTheme.typography.headlineMedium)
        }

   /* when {
        viewModel.isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        viewModel.errorMessage != null -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: ${viewModel.errorMessage}", color = Color.Red)
            }
        }

        else -> {
            LazyColumn {
                items(viewModel.posts) { post ->
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = post.title, style = MaterialTheme.typography.titleLarge)
                        Text(text = post.body, style = MaterialTheme.typography.bodyMedium)
                        HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
                    }
                }
            }
        }
    }*/
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val pagerState = rememberPagerState(initialPage = 0, pageCount = {
        BottomNavItem.items.size
    })
    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        bottomBar = {
            NavigationBar {
                BottomNavItem.items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        icon = {
                            Icon(
                                painterResource(item.icon), contentDescription = item.label, modifier = Modifier
                                    .size(30.dp)
                            )
                        },
                        label = { Text(item.label) },
                        modifier = Modifier
                            .padding(10.dp)
                            .height(50.dp)
                    )
                }
            }
            //BottomNavigationBar(navController)
        }
    ) { padding ->
        Box(/*modifier = Modifier.padding(padding)*/) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) { page ->
                when (page) {
                    0 -> HomeScreen()
                    1 -> ProfileScreen()
                    2 -> SettingsScreen()
                }
            }
            //BottomNavGraph(navController)
        }
    }
}
