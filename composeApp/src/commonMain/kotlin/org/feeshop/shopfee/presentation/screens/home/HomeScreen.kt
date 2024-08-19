package org.feeshop.shopfee.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import org.feeshop.shopfee.presentation.composable.SpSimpleTextField
import org.feeshop.shopfee.resources.Resources
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        this.search(onClick = { })
    }

}

private fun LazyListScope.search(onClick:()->Unit){
    item {
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

}
