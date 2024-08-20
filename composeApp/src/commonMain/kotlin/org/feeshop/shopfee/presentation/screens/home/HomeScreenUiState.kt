package org.feeshop.shopfee.presentation.screens.home

import org.feeshop.shopfee.presentation.base.ErrorState


data class HomeScreenUiState(
    val selectedType: OrderSelectType = OrderSelectType.COFFEE,
    val isLoggedIn: Boolean = false,
    val isLoading: Boolean = false,
    val error: ErrorState? = null
) {
    enum class OrderSelectType(type: String) {
        COFFEE("Coffee"),
        NON_COFFEE("Non Coffee"),
        PASTRY("Pastry")
    }
}


