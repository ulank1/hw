package com.hfad.quizzapp.data.repository

import com.hfad.quizzapp.data.api.QuizApi
import com.hfad.quizzapp.data.model.mainModel.MainModel
import com.hfad.quizzapp.data.model.quizModel.QuizModel
import retrofit2.Response
import java.lang.Exception


class MainRepo(private val api: QuizApi) {

    var model: MainModel = MainModel()

    suspend fun getCategory() = api.getCategory()

    suspend fun getQuiz(): Response<QuizModel>? {
       return try {
            api.getQuiz(model.amount, model.category, model.difficulty)
        }catch (e:Exception){
            e.printStackTrace()
           null
        }
    }
}