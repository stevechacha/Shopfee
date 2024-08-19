package org.feeshop.shopfee.resources

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import shopfee.composeapp.generated.resources.Res
import shopfee.composeapp.generated.resources.*


data class ShopCoffeeDrawableResources (
    val bf : DrawableResource = Res.drawable.pana,
    val logo : DrawableResource = Res.drawable.logo2,
    val cutie: DrawableResource = Res.drawable.cuate
)
@OptIn(ExperimentalResourceApi::class)
val CoffeeDrawableDarkResources = ShopCoffeeDrawableResources(
    bf = Res.drawable.compose_multiplatform,
)
