package org.feeshop.shopfee.presentation.screens.auth.login

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.feeshop.shopfee.presentation.composable.HeadFirstCard
import org.feeshop.shopfee.presentation.composable.SpBrandBackgroundContainer
import org.feeshop.shopfee.presentation.composable.SpButton
import org.feeshop.shopfee.presentation.composable.SpTextField
import org.feeshop.shopfee.resources.Resources

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onClickLogin:()->Unit = {},
    onClickRegister: () -> Unit = {}
) {
    SpBrandBackgroundContainer {
        HeadFirstCard(
            textHeader = Resources.strings.dontHaveAnAccount,
            textSubHeader = Resources.strings.registerHint,
            onClick = onClickRegister
        ){
            SpTextField(
                value = "",
                onValueChange = {},
                placeholder = Resources.strings.phoneNumberHint,
                label = Resources.strings.phoneNumberLabel,
                modifier = Modifier.padding(top = 16.dp),
                keyboardType = KeyboardType.Phone
            )

            SpButton(
                onClick = onClickLogin,
                textButtons = Resources.strings.loginHint,
                enable = true,
                modifier = Modifier.padding(top = 32.dp)
            )
        }
    }

}