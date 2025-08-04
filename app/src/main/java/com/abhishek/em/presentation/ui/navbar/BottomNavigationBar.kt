package com.abhishek.em.presentation.ui.navbar

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.abhishek.em.navigation.botttombar.BottomNavItem

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route

    NavigationBar {
        BottomNavItem.items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(
                    painterResource(item.icon),
                    contentDescription = item.label,
                    modifier = Modifier
                        .size(30.dp))
                },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            // Avoid multiple copies of the same destination
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                    }
                },
                modifier = Modifier.padding(10.dp)
                    .height(50.dp)
            )
        }
    }
}
