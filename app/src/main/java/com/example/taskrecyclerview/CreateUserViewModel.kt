package com.example.taskrecyclerview

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CreateUserViewModel (
    private val repository: Repository,
    application: Application
): AndroidViewModel(application) {

    fun saveUser(userName: String, password:String){
        viewModelScope.launch {
            val user = UsersDataClass(userName, password)
            if (isUserExists(user)) {
                Toast.makeText(getApplication(), "Username and password already exist", Toast.LENGTH_SHORT).show()
            } else {
                repository.insertUser(user)
                Toast.makeText(getApplication(), "Username and password saved successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private suspend fun isUserExists(userDataClass: UsersDataClass): Boolean {
        return repository.isUserExists((userDataClass.userName))
    }
}