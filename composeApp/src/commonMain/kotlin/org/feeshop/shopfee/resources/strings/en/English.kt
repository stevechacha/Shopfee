package org.feeshop.shopfee.resources.strings.en

import org.feeshop.shopfee.resources.strings.IStringResources

data class English(
    override val appName: String = "Jetflix",
    override val home: String = "Home",
    override val nameLabel: String = "Name",
    override val nameHint: String = "Input your name",
    override val phoneNumberLabel: String = "No. Handphone",
    override val phoneNumberHint: String = "imput your No. Handphone",
    override val haveAnAccount: String= "Have an account?",
    override val loginHint: String = "Login",
    override val dontHaveAnAccount: String = "Don’t have an account?",
    override val registerHint: String = "Register",
    override val searchHint: String = "Search",
    override val confirmOTPCodeTitle: String = "Confirm OTP code",
    override val confirmOTPDescription: String= "Enter the 5-digit code that has been sent from SMS to complete your account registration",
    override val haveSentConfirmationCode: String = "Haven't got the confirmation code yet?",
    override val resendVerificationCode: String = "Resend"

    ): IStringResources
