package org.feeshop.shopfee.presentation.screens.otp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.feeshop.shopfee.presentation.composable.OtpTextField
import org.feeshop.shopfee.presentation.composable.ResendText
import org.feeshop.shopfee.presentation.composable.SpBrandBackgroundContainer
import org.feeshop.shopfee.presentation.composable.SimpleTextButton
import org.feeshop.shopfee.presentation.composable.SpAppBar
import org.feeshop.shopfee.presentation.composable.SpButton
import org.feeshop.shopfee.presentation.navigation.Screens
import org.feeshop.shopfee.resources.Resources
import org.jetbrains.compose.resources.painterResource
import utils.getStatusBarPadding

@Composable
fun OtpScreen(
    navController: NavController
) {
    val otpInputs = List(6) { remember { mutableStateOf("") } }
        SpBrandBackgroundContainer {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SpAppBar(
                    title = "Input your PIN",
                    navigateBack = {}
                )

                Image(
                    painter = painterResource(Resources.images.cutie),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(.4f).fillMaxHeight(.3f)
                        .padding(getStatusBarPadding())
                )
                Text(
                    text = "Enter 6 digit PIN for secure account access",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top =32.dp)
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
                    firstText = "Forgot PIN?",
                    clickedText = "Change PIN",
                    onClick = {}
                )



                SpButton(
                    textButtons = "Confirm",
                    modifier = Modifier.padding(top = 24.dp).padding(16.dp),
                    onClick = {
                        val otp = otpInputs.joinToString("") { it.value }
                        println("Entered OTP: $otp")
                    },
                )
            }
        }

}

