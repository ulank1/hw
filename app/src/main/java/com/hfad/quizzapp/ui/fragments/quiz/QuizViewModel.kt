package com.hfad.quizzapp.ui.fragments.quiz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.ui.base.BaseViewModel
import com.hfad.quizzapp.data.model.quizModel.QuizModel
import com.hfad.quizzapp.data.repository.MainRepo
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response

class QuizViewModel(private val repo: MainRepo) : BaseViewModel() {

    var quizLiveData = MutableLiveData<QuizModel>()
    var errorLiveData = MutableLiveData<ArrayList<String>>()

    fun getQuiz() {
        viewModelScope.launch {
            val response = repo.getQuiz()
            if (response!=null){
                if (response.isSuccessful){

                    val quiz = response.body()
                    quiz?.results?.forEach {
                        val answers:ArrayList<String> = ArrayList()
                        if (it.type=="multiple"){
                            answers.add(it.correctAnswer)
                            answers.add(it.incorrectAnswers[0])
                            answers.add(it.incorrectAnswers[1])
                            answers.add(it.incorrectAnswers[2])
                        }
                        answers.shuffle()
                        it.shuffleAnswers = answers
                    }

                    quizLiveData.value = quiz!!

                }else{
                    try {
                        val json = JSONObject(response.errorBody()?.string().toString())
                        val errors:ArrayList<String> = ArrayList()
                        json.keys().forEach {
                           errors.add(json.get(it).toString())
                        }
                        errorLiveData.value = errors
                    }catch (e:Exception){

                    }
                }
            }else{
                errorLiveData.value = arrayListOf("Подключитесь к интернету")
            }
        }
    }
}