package com.hfad.quizzapp.data.api

import com.hfad.quizzapp.data.model.quizModel.QuizModel
import com.hfad.quizzapp.data.model.category.Category
import retrofit2.Response
import retrofit2.http.*

interface QuizApi {

    @GET("api.php")
    suspend fun getQuiz(
        @Query("amount") id: Int,
        @Query("category") amount: Int,
        @Query("difficulty") difficulty: String
    ): Response<QuizModel>

    @GET("api_category.php")
    suspend fun getCategory(
    ): Response<Category>

    @FormUrlEncoded
    @POST("create.php")
    fun createQuiz(
        @Field("category") category: String,
        @Field("type") type: String
    )

    @POST("create.php")
    fun createQuiz(
        @Body quiz: QuizModel
    )

    @GET("user/post/{id}/")
    fun getPost(
        @Path("id") id: Int,
        @Query("amount") amount: Int
    )
}