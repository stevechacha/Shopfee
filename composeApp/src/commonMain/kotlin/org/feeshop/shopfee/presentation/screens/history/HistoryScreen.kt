package org.feeshop.shopfee.presentation.screens.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mohamedrejeb.calf.ui.datepicker.AdaptiveDatePicker
import com.mohamedrejeb.calf.ui.datepicker.rememberAdaptiveDatePickerState
import org.feeshop.shopfee.presentation.composable.SpBrandBackgroundContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(modifier: Modifier = Modifier) {

        val state = rememberAdaptiveDatePickerState()

        LaunchedEffect(state.selectedDateMillis) {
            // Do something with the selected date
        }

        AdaptiveDatePicker(
            state = state,
        )


}