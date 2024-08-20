package org.feeshop.shopfee.domain.entities

import org.jetbrains.compose.resources.DrawableResource


data class CoffeeItemModel(
    val name: String,
    val description: String,
    val imageRes: DrawableResource,
    val price: String,
)
