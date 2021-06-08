package com.hfad.quizzapp.di

import com.example.core.ui.base.BaseViewModel
import com.hfad.quizzapp.ui.fragments.discover.DiscoverViewModel
import com.hfad.quizzapp.ui.fragments.home.HomeViewModel
import com.hfad.quizzapp.ui.fragments.map.MapViewModel
import com.hfad.quizzapp.ui.fragments.profile.ProfileViewModel
import com.hfad.quizzapp.ui.fragments.quiz.QuizViewModel
import com.hfad.quizzapp.ui.main.MainViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { MapViewModel() }
    viewModel { BaseViewModel() }
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { DiscoverViewModel(get()) }
    viewModel { QuizViewModel(get()) }
}