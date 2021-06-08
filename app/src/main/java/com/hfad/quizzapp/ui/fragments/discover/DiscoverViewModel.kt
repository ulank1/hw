package com.hfad.quizzapp.ui.fragments.discover

import androidx.lifecycle.liveData
import com.example.core.ui.base.BaseViewModel
import com.hfad.quizzapp.data.repository.MainRepo
import kotlinx.coroutines.Dispatchers

class DiscoverViewModel(private val repo: MainRepo) : BaseViewModel() {

    fun getCategory() = liveData(Dispatchers.IO) {
        emit(repo.getCategory())
    }

    var amount: Int
        get() = repo.model.amount
        set(value) {
            repo.model.amount = value
        }

    var category: Int
        get() = repo.model.category
        set(value) {
            repo.model.category = value
        }

    var difficulty: String
        get() = repo.model.difficulty
        set(value) {
            repo.model.difficulty = value
        }
}