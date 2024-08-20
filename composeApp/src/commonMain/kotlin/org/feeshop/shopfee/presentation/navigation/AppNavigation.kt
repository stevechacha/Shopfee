package org.feeshop.shopfee.presentation.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.feeshop.shopfee.presentation.screens.account.AccountScreen
import org.feeshop.shopfee.presentation.screens.auth.login.LoginScreen
import org.feeshop.shopfee.presentation.screens.auth.register.RegisterScreen
import org.feeshop.shopfee.presentation.screens.confirmVerificationCode.ConfirmVerificationCodeScreen
import org.feeshop.shopfee.presentation.screens.history.HistoryScreen
import org.feeshop.shopfee.presentation.screens.home.HomeScreen
import org.feeshop.shopfee.presentation.screens.onboarding.OnBoardViewModel
import org.feeshop.shopfee.presentation.screens.onboarding.OnBoardingMainScreen
import org.feeshop.shopfee.presentation.screens.otp.OtpScreen
import org.koin.compose.currentKoinScope


@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: Screens = Screens.Register,
) {
    NavHost(
        modifier = Modifier.then(modifier),
        startDestination = startDestination.route,
        navController = navController,
    ) {

        composable(Screens.OnBoarding.route) {
//            val onBoardViewModel = koinViewModel<OnBoardViewModel>()
            OnBoardingMainScreen(
                onClickAction = {},
            )
        }

        composable(Screens.Register.route){
            RegisterScreen(
                onClickRegister = { navController.navigate(Screens.ConfirmRegisterCode.route)},
                onClickLogin = {navController.navigate(Screens.Login.route)}
            )
        }

        composable(Screens.ConfirmRegisterCode.route){
            ConfirmVerificationCodeScreen(navController)
        }

        composable(Screens.Login.route){
            LoginScreen(
                onClickLogin = { navController.navigate(Screens.Otp.route)},
                onClickRegister = { navController.navigate(Screens.Register.route)}
            )
        }

        composable(Screens.Otp.route){
            OtpScreen(navController)
        }

        composable(Screens.Home.route){
            HomeScreen()
        }

        composable(Screens.History.route){
            HistoryScreen()
        }

        composable(Screens.Account.route){
            AccountScreen()
        }

    }
}

@Composable
inline fun <reified T: ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}


sealed class Screens(val route: String) {
    data object OnBoarding : Screens("gallery")
    data object Login: Screens("login")
    data object Register: Screens("register")
    data object ConfirmRegisterCode: Screens("register_code")
    data object Otp: Screens("otp")
    data object Home: Screens("home")
    data object History: Screens("history")
    data object Account: Screens("account")
    data object ArtsScreen : Screens("arts")
    data object DetailScreen : Screens("detail/{id}")
    data object CollectionScreen : Screens("collection")
}


