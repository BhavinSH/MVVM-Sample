package com.mvvm.sample.repository

import androidx.lifecycle.MutableLiveData
import com.mvvm.sample.api.APIEndPoints
import com.mvvm.sample.api.RetrofitClient
import com.mvvm.sample.model.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class UserRepository {
    private var mDefaultAPI: APIEndPoints? = null

    init {
        mDefaultAPI = RetrofitClient()
            .createService(APIEndPoints::class.java)
    }

    /**
     * Fetch the user data using the Retrofit API Call
     */
    fun getUsers(): MutableLiveData<List<UserData>> {
        val userLiveData = MutableLiveData<List<UserData>>()

        mDefaultAPI?.getUsers()?.enqueue(object : Callback<List<UserData>> {
            override fun onResponse(
                call: Call<List<UserData>>,
                response: Response<List<UserData>>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    userLiveData.value = body
                }
            }

            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return userLiveData
    }
}