package com.abhishek.em.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    navigation(startDestination = Routes.Login, route = Routes.Main) {
//        composable(Routes.Greeting) {
//            GreetingScreen(navController = navController)
//        }
//        composable(Routes.Welcome) { backStackEntry ->
//            WelcomeScreen()
//        }
    }
}
