package com.mvvm.sample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.mvvm.sample.repository.UserRepository
import com.mvvm.sample.model.UserData

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    private var isProgressShown = MutableLiveData<Boolean>()
    private var mUserList = MutableLiveData<List<UserData>>()

    fun getUserList(): MutableLiveData<List<UserData>> {
        return repository.getUsers() // Call a repository in order to fetch the data
    }

    fun isProgress() = isProgressShown

    init {
        getUsers()
    }

    /**
     *  Fetch user list from a repository
     */
    private fun getUsers() {
        isProgress().value = true
        Transformations.map(getUserList()) {
            mUserList.value = it
            isProgress().value = false
        }
    }
}