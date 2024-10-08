package utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable

@Composable
expect fun setInsetsController(isDark: Boolean)

@Composable
expect fun getStatusBarPadding(): PaddingValues

@Composable
expect fun getNavigationBarPadding(): PaddingValues