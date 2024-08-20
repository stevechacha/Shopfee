package org.feeshop.shopfee.presentation.screens.coffee

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.feeshop.shopfee.presentation.composable.SpBrandBackgroundContainer

@Composable
fun CoffeeScreen(modifier: Modifier = Modifier) {
    SpBrandBackgroundContainer {
        Text("Name")
    }
}