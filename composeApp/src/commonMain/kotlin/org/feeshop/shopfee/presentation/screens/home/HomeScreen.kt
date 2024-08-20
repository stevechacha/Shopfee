package org.feeshop.shopfee.presentation.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.feeshop.shopfee.presentation.composable.BpAnimatedTabLayout
import org.feeshop.shopfee.presentation.composable.ImageSlider
import org.feeshop.shopfee.presentation.composable.SpAnimatedTabLayout
import org.feeshop.shopfee.presentation.composable.SpSimpleTextField
import org.feeshop.shopfee.presentation.screens.coffee.CoffeeScreen
import org.feeshop.shopfee.presentation.screens.home.components.CoffeeItem
import org.feeshop.shopfee.presentation.screens.home.components.dataList
import org.feeshop.shopfee.presentation.screens.home.components.getItemsForTab
import org.feeshop.shopfee.presentation.screens.home.components.imageList
import org.feeshop.shopfee.presentation.screens.nonCoffee.NonCoffeeScreen
import org.feeshop.shopfee.presentation.screens.pastry.PastryScreen
import org.feeshop.shopfee.resources.Resources

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val homeScreenViewModel: HomeScreenViewModel = viewModel()
    val state by homeScreenViewModel.uiState.collectAsState()
    val orderTabs = HomeScreenUiState.OrderSelectType.entries
    var selectedTab by remember { mutableStateOf(HomeScreenUiState.OrderSelectType.COFFEE) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        stickyHeader {
            Search(onClick = { })
        }

        item {
            ImageSlider(
                modifier = Modifier.padding(horizontal = 16.dp),
                onItemClickListener = {  },
                images = listOf("1","2","3"),
                indicatorAlignment = Alignment.BottomCenter
            )
        }
        item {
            SpAnimatedTabLayout(
                tabItems = HomeScreenUiState.OrderSelectType.entries,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            ){ type ->
                when(type){
                    HomeScreenUiState.OrderSelectType.COFFEE -> {
                        CoffeeScreen()
                    }

                    HomeScreenUiState.OrderSelectType.NON_COFFEE -> {
                        NonCoffeeScreen()
                    }

                    HomeScreenUiState.OrderSelectType.PASTRY -> {
                        PastryScreen()
                    }
                }
            }
        }

        items(dataList.size) { item ->
            CoffeeItem(
                item = dataList[item]
            )
        }

    }

}

@Composable
private fun Search(onClick:()->Unit){
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            SpSimpleTextField(
                text = "",
                hint = Resources.strings.searchHint,
                hintColor = MaterialTheme.colorScheme.onSecondary,
                onTrailingIconClick = onClick,
                onValueChange = { },
                onClick = onClick,
                modifier = Modifier.fillMaxWidth(.85f).onFocusChanged {
                    if (it.hasFocus) {
                        onClick()
                    }
                }
            )

            IconButton(
                onClick = {}
            ){
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp)
                )
            }
        }

}
