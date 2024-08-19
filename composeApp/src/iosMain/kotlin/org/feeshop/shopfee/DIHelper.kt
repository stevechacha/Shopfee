package org.feeshop.shopfee

import org.koin.core.context.startKoin
import org.feeshop.shopfee.di.appModule


fun initKoin() {
    startKoin {
        modules(
            appModule(),

        )
    }
}