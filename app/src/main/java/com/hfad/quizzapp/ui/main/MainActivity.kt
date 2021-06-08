package com.hfad.quizzapp.ui.main

import androidx.navigation.findNavController
import com.example.core.ui.base.BaseActivity
import com.hfad.quizzapp.R
import com.hfad.quizzapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    ActivityMainBinding::inflate,
    MainViewModel::class.java
) {

    override fun setUpView() {
        val navController = findNavController(R.id.nav_host_fragment)
    }
}