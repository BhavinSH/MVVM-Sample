package com.mvvm.sample.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_BASE_URL = "https://jsonplaceholder.typicode.com/"

class RetrofitClient {
    private var okBuilder: OkHttpClient.Builder? = null
    private var adapterBuilder: Retrofit.Builder? = null

    init {
        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .create()

        okBuilder = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okBuilder!!.addInterceptor(interceptor)

        adapterBuilder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    fun <S> createService(serviceClass: Class<S>?): S {
        return adapterBuilder
            ?.client(okBuilder!!.build())
            ?.build()
            ?.create(serviceClass)!!
    }
}