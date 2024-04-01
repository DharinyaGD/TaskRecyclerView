package com.example.taskrecyclerview

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CreateUserViewModelFactory (
    private val application: Application,
    private val userRepository: Repository
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CreateUserViewModel::class.java)) {
            return CreateUserViewModel(userRepository, application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}