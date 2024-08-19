package org.feeshop.shopfee.presentation.screens.confirmVerificationCode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.feeshop.shopfee.presentation.composable.OtpTextField
import org.feeshop.shopfee.presentation.composable.ResendText
import org.feeshop.shopfee.presentation.composable.SpAppBar
import org.feeshop.shopfee.presentation.composable.SpButton
import org.feeshop.shopfee.resources.Resources

@Composable
fun ConfirmVerificationCodeScreen(modifier: Modifier = Modifier) {
    val otpInputs = List(5) { remember { mutableStateOf("") } }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpAppBar(
            title = Resources.strings.confirmOTPCodeTitle,
            navigateBack = {}
        )

        Text(
            text = "Phone Number Sent Code",
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = Resources.strings.confirmOTPDescription,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            otpInputs.forEachIndexed { index, input ->
                OtpTextField(
                    inputValue = input,
                    onNextFocus = if (index < otpInputs.size - 1) otpInputs[index + 1] else null
                )
            }
        }

        ResendText(
            firstText = Resources.strings.haveSentConfirmationCode,
            clickedText = Resources.strings.resendVerificationCode,
            onClick = {},
            modifier = Modifier.padding(top = 32.dp)
        )

        SpButton(
            textButtons = "Confirm",
            modifier = Modifier.padding(top = 56.dp).padding(16.dp),
            onClick = {
                val otp = otpInputs.joinToString("") { it.value }
                println("Entered OTP: $otp")
            },
        )
    }

}