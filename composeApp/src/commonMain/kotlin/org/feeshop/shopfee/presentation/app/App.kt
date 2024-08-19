package org.feeshop.shopfee.presentation.app

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.feeshop.shopfee.presentation.navigation.AppNavigation
import org.feeshop.shopfee.presentation.navigation.Screens
import org.feeshop.shopfee.presentation.screens.main.StandardScaffold
import org.feeshop.shopfee.resources.ShopCoffeeTheme
import org.koin.compose.KoinContext
import utils.getNavigationBarPadding

@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    ShopCoffeeTheme {
        KoinContext {
            StandardScaffold(
                navController = navController,
                showBottomBar = shouldShowBottomBar(navBackStackEntry),
                isLoggedIn = true,
            ){
                AppNavigation(navController)
            }
        }
    }
}



fun shouldShowBottomBar(backStackStackEntry: NavBackStackEntry?): Boolean {
    return backStackStackEntry?.destination?.route in listOf(
        Screens.Home.route,
        Screens.History.route,
        Screens.Account.route,
    )
}