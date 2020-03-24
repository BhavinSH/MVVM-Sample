package com.mvvm.sample.api

import com.mvvm.sample.model.UserData
import com.mvvm.sample.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIEndPoints {

    @GET("users")
    fun getUsers(): Call<List<UserData>>
}