package com.mvvm.sample.model

import com.google.gson.annotations.SerializedName

class UserData {/*
    @SerializedName("id")
    private val id = Int*/

    @SerializedName("name")
    private val name = String()

    @SerializedName("email")
    private val email = String()

    //fun id() = id

    fun name() = name
    
    fun email() = email
}