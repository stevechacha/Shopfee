package org.feeshop.shopfee

import androidx.compose.ui.window.ComposeUIViewController
import org.feeshop.shopfee.presentation.app.App
import org.koin.core.context.startKoin
import org.feeshop.shopfee.di.appModule


fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin {
            modules(appModule())
        }
    }

) { App() }