package com.abhishek.em.navigation.botttombar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abhishek.em.presentation.ui.HomeScreen
import com.abhishek.em.presentation.ui.ProfileScreen
import com.abhishek.em.presentation.ui.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Profile.route) {
            ProfileScreen()
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen()
        }
    }
}
