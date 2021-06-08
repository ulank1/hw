package com.hfad.quizzapp.di

import com.hfad.quizzapp.data.repository.MainRepo
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepo(get()) }
}