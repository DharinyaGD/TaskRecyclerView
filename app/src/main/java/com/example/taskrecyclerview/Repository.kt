package com.example.taskrecyclerview

import kotlinx.coroutines.flow.Flow

class Repository (private val userDao: DataAccessObject) {

    suspend fun insertUser(user: UsersDataClass){
        userDao.insertUser(user)
    }

    // code to find is there is the user or not 
    suspend fun isUserExists(username: String): Boolean {
        return userDao.getUserByUsername(username) != null
    }

    fun getAllUsers(): Flow<List<UsersDataClass>> {
        return userDao.getAllUsers()
    }
}
