package com.abhishek.em.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.abhishek.em.presentation.ui.auth.LoginScreen
import com.abhishek.em.presentation.ui.auth.SplashScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    composable(Routes.Splash) {
        SplashScreen(navController)
    }
    composable(Routes.Login) {
        LoginScreen(navController)
    }
}

// Gote mu emin
