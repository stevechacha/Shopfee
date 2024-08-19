package org.feeshop.shopfee.presentation.screens.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import org.feeshop.shopfee.presentation.navigation.Screens


data class BottomNavItem(
    val screen: String,
    val icon: ImageVector? = null,
    val title: String? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null,
)

@Composable
fun getBottomNavigation(): List<BottomNavItem> = listOf(
    BottomNavItem(
        screen = Screens.Home.route,
        icon = Icons.Filled.Home,
        title = "Home",
        contentDescription = "Home"
    ),
    BottomNavItem(
        screen = Screens.History.route,
        icon = Icons.Filled.History,
        title = "History",
        contentDescription = "History"
    ),
    BottomNavItem(
        screen = Screens.Account.route,
        icon = Icons.Filled.Person,
        title = "Account",
        contentDescription = "Account"
    )
)

