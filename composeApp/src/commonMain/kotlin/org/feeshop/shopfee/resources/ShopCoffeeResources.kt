package org.feeshop.shopfee.resources

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalLayoutDirection
import org.feeshop.shopfee.presentation.composable.theme.AppTheme
import org.feeshop.shopfee.resources.strings.IStringResources
import utils.LanguageCode
import utils.LocalizationManager
import utils.setInsetsController


private val localStringResources = staticCompositionLocalOf<IStringResources> {
    error("CompositionLocal IStringResources not present")
}
private val localShopCoffeeDrawableResources = staticCompositionLocalOf { ShopCoffeeDrawableResources() }

@Composable
fun ShopCoffeeTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    languageCode: LanguageCode = LanguageCode.EN,
    content: @Composable () -> Unit
) {
    val drawableResources =
        if (useDarkTheme) CoffeeDrawableDarkResources else ShopCoffeeDrawableResources()
    CompositionLocalProvider(
        localStringResources provides LocalizationManager.getStringResources(languageCode),
        localShopCoffeeDrawableResources provides drawableResources,
        LocalLayoutDirection provides LocalizationManager.getLayoutDirection(languageCode)
    ) {
        AppTheme(dynamicColor = useDarkTheme) {
            setInsetsController(useDarkTheme)
            content()
        }
    }
}

object Resources {
    val strings: IStringResources
        @Composable
        get() = localStringResources.current

    val images: ShopCoffeeDrawableResources
        @Composable
        get() = localShopCoffeeDrawableResources.current
}
