package com.hfad.quizzapp.data.model.quizModel

import com.google.gson.annotations.SerializedName


data class QuizModel(

    @SerializedName("response_code") var responseCode: Int,
    @SerializedName("results") var results: List<Results>

)

data class Results(

    @SerializedName("category") var category: String,
    @SerializedName("type") var type: String,
    @SerializedName("difficulty") var difficulty: String,
    @SerializedName("question") var question: String,
    @SerializedName("correct_answer") var correctAnswer: String,
    @SerializedName("incorrect_answers") var incorrectAnswers: List<String>,
    var answer:String? = null,
    var isSkip:Boolean = false,
    var shuffleAnswers:List<String>
)
