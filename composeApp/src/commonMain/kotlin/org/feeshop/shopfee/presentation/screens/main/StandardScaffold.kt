package org.feeshop.shopfee.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import org.feeshop.shopfee.presentation.navigation.Screens


@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    isLoggedIn: Boolean,
    bottomNavItems: List<BottomNavItem> = getBottomNavigation(),
    content: @Composable () -> Unit
) {

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.background,
                ) {
                    bottomNavItems.forEachIndexed { i, bottomNavItem ->
                        StandardBottomNavItem(
                            icon = bottomNavItem.icon,
                            title = bottomNavItem.title,
                            contentDescription = bottomNavItem.contentDescription,
                            selected = bottomNavItem.screen == navController.currentDestination?.route,
                            alertCount = bottomNavItem.alertCount,
                            enabled = bottomNavItem.icon != null
                        ) {
                            if (navController.currentDestination?.route != bottomNavItem.screen) {
                                navController.navigate(bottomNavItem.screen)
                            }
                        }
                    }
                }
            }
        },
        modifier = modifier
    ) { padding ->
        Box(Modifier.padding(padding)) {
            content()
        }
    }
}





