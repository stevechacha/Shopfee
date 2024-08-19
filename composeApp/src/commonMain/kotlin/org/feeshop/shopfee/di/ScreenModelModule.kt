package org.feeshop.shopfee.di

import org.feeshop.shopfee.presentation.screens.onboarding.OnBoardViewModel
import org.koin.dsl.module

val ScreenModelModule = module {
    factory { OnBoardViewModel(repository = get()) }
}