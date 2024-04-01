package com.example.taskrecyclerview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserRvViewModel (userRepository: Repository, application: Application) : AndroidViewModel(application) {

    private val userDao = AppDataBase.getDataBase(application).userDao()
    val userList: Flow<List<UsersDataClass>> = userRepository.getAllUsers()

    fun deleteUserInfo(entity: UsersDataClass) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.deleteUser(entity)
        }
    }
}