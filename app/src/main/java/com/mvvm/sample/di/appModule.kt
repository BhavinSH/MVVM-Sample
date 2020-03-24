package com.mvvm.sample.di

import com.mvvm.sample.repository.UserRepository
import com.mvvm.sample.viewmodel.UserViewModel
import org.koin.dsl.module

val appModule = module {
    factory { UserViewModel(get()) }

    factory { UserRepository() }
}