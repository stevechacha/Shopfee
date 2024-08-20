package org.feeshop.shopfee.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.feeshop.shopfee.domain.entities.CoffeeItemModel
import org.feeshop.shopfee.presentation.screens.home.HomeScreenUiState
import org.feeshop.shopfee.resources.Resources
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import shopfee.composeapp.generated.resources.Res
import shopfee.composeapp.generated.resources.cuate
import shopfee.composeapp.generated.resources.cuate3
import shopfee.composeapp.generated.resources.ilustrasi1

@Composable
fun CoffeeItem(item: CoffeeItemModel) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(item.imageRes),
            contentDescription = item.name,
            modifier = Modifier.size(64.dp).clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(item.name, fontWeight = FontWeight.Bold)
            Text(item.description, style = MaterialTheme.typography.titleMedium, color = Color.Gray)
        }
        Text(
            text = item.price,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}


fun getItemsForTab(tab: HomeScreenUiState.OrderSelectType): List<CoffeeItemModel> {
    return when (tab) {
        HomeScreenUiState.OrderSelectType.COFFEE -> listOf(
            CoffeeItemModel("Coffee Milk", "Ice americano + fresh milk", Res.drawable.ilustrasi1, "Rp25.000"),
            CoffeeItemModel("Cocoa Caramel Latte", "Steamed milk with mocha and caramel sauces", Res.drawable.ilustrasi1, "Rp35.500")
            // Add more items...
        )
        HomeScreenUiState.OrderSelectType.NON_COFFEE -> listOf(
            CoffeeItemModel("Green Tea Latte", "Steamed milk with green tea",Res.drawable.ilustrasi1, "Rp30.000")
            // Add more items...
        )
        HomeScreenUiState.OrderSelectType.PASTRY -> listOf(
            // Add more items...
        )
    }
}

val dataList = listOf(
    CoffeeItemModel("Croissant", "Buttery and flaky", Res.drawable.ilustrasi1, "Rp15.000"),
    CoffeeItemModel("Coffee Milk", "Ice americano + fresh milk", Res.drawable.ilustrasi1, "Rp25.000"),
    CoffeeItemModel("Coffee Milk", "Ice americano + fresh milk", Res.drawable.ilustrasi1, "Rp25.000"),
    CoffeeItemModel("Coffee Milk", "Ice americano + fresh milk", Res.drawable.ilustrasi1, "Rp25.000"),
    CoffeeItemModel("Coffee Milk", "Ice americano + fresh milk", Res.drawable.ilustrasi1, "Rp25.000"),
    CoffeeItemModel("Coffee Milk", "Ice americano + fresh milk", Res.drawable.ilustrasi1, "Rp25.000"),
    CoffeeItemModel("Coffee Milk", "Ice americano + fresh milk", Res.drawable.ilustrasi1, "Rp25.000"),
    CoffeeItemModel("Coffee Milk", "Ice americano + fresh milk", Res.drawable.ilustrasi1, "Rp25.000"),
    CoffeeItemModel("Coffee Milk", "Ice americano + fresh milk", Res.drawable.ilustrasi1, "Rp25.000"),
    CoffeeItemModel("Cocoa Caramel Latte", "Steamed milk with mocha and caramel sauces", Res.drawable.ilustrasi1, "Rp35.500")
    // Add more items...
)

data class CoffeeItems(
    val image: DrawableResource
)


val imageList = listOf(
    CoffeeItems(
        Res.drawable.ilustrasi1
    ),
    CoffeeItems(
        Res.drawable.cuate
    ),
    CoffeeItems(
        Res.drawable.cuate3
    )
)

