package org.feeshop.shopfee.presentation.screens.onboarding

import org.jetbrains.compose.resources.DrawableResource
import shopfee.composeapp.generated.resources.Res
import shopfee.composeapp.generated.resources.ilustrasi1
import shopfee.composeapp.generated.resources.ilustrasi2
import shopfee.composeapp.generated.resources.pana


sealed class OnBoardingPage(
    val image: DrawableResource,
    val title: String,
    val description: String
) {
    data object First: OnBoardingPage(
        image = Res.drawable.ilustrasi1,
        title = "Choose and customize your Drinks",
        description = "Customize your own drink exactly how you like it by adding any topping you like!!!"
    )
    data object Second: OnBoardingPage(
        image = Res.drawable.ilustrasi2,
        title = "Quickly and easly",
        description = "You can place your order quickly and easly without wasting time. You can also schedule orders via your smarthphone."
    )
    data object Third: OnBoardingPage(
        image = Res.drawable.pana,
        title = "Get and Redeem Voucher",
        description = "Exciting prizes await you! Redeem yours by collecting all the points after purchase in the app!"
    )
}