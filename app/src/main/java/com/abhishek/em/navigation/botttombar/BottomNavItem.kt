package com.abhishek.em.navigation.botttombar

import androidx.annotation.DrawableRes
import com.abhishek.em.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int,
    val label: String
) {
    object Home : BottomNavItem("home", R.drawable.ic_launcher_foreground, "Home")
    object Profile : BottomNavItem("profile", R.drawable.ic_launcher_foreground, "Profile")
    object Settings : BottomNavItem("settings", R.drawable.ic_launcher_foreground, "Settings")

    companion object {
        val items = listOf(Home, Profile, Settings)
    }
}
