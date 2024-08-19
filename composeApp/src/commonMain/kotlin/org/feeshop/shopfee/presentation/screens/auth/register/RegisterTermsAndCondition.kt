package org.feeshop.shopfee.presentation.screens.auth.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun RegisterTermsAndCondition(
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit
) {
    val uriHandler = LocalUriHandler.current
    Box(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center,
    ) {

        val annotatedText = buildAnnotatedString {
            append("By tapping \"Register\" you agree to our ")

            pushStringAnnotation(tag = "TERMS", annotation = "terms")
            withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
                append("Terms of Use")
            }
            pop()

            append(" and ")

            // Privacy Policy clickable text in blue
            pushStringAnnotation(tag = "PRIVACY", annotation = "privacy")
            withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
                append("Privacy Policy")
            }
            pop()
        }

        // Display the annotated text
        ClickableText(
            text = annotatedText,
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.fillMaxWidth().clickable { }.padding(8.dp),
        ) { offset ->
            // Handle clicks on the annotated sections
            annotatedText.getStringAnnotations("TERMS", start = offset, end = offset).firstOrNull()?.let {
                onTermsClick()
            }
            annotatedText.getStringAnnotations("PRIVACY", start = offset, end = offset).firstOrNull()?.let {
                onPrivacyClick()
                uriHandler.openUri("https://equitygroupholdings.com/privacy-policy/")

            }
        }
    }
}

