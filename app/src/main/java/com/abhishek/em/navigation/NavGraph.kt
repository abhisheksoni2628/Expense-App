package com.abhishek.em.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.abhishek.em.navigation.Routes
import com.abhishek.em.navigation.authNavGraph
import com.abhishek.em.navigation.mainNavGraph

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Splash
    ) {
        authNavGraph(navController)
        mainNavGraph(navController)
    }
}