package org.feeshop.shopfee.presentation.screens.auth.register

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
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onClickRegister:()->Unit = {},
    onClickLogin: () -> Unit = {}
) {
    SpBrandBackgroundContainer {
        HeadFirstCard(
            textHeader = Resources.strings.haveAnAccount,
            textSubHeader = Resources.strings.loginHint,
            onClick =  onClickLogin
        ){
            SpTextField(
                value = "",
                onValueChange = {},
                placeholder = Resources.strings.nameHint,
                label = Resources.strings.nameLabel,
                modifier = Modifier.padding(top = 16.dp)
            )

            SpTextField(
                value = "",
                onValueChange = {},
                placeholder = Resources.strings.phoneNumberHint,
                label = Resources.strings.phoneNumberLabel,
                modifier = Modifier.padding(top = 16.dp),
                keyboardType = KeyboardType.Phone
            )

            RegisterTermsAndCondition(
                onTermsClick = { /* Handle Terms of Use click */ },
                onPrivacyClick = { /* Handle Privacy Policy click */ }
            )


            SpButton(
                textButtons = Resources.strings.registerHint,
                modifier = Modifier.padding(top = 16.dp),
                onClick = onClickRegister,
                enable = true
            )
        }
    }

}