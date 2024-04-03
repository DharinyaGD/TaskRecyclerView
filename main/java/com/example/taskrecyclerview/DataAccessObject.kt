package com.example.taskrecyclerview

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao

interface DataAccessObject {

    @Insert
    suspend fun insertUser(userDataClass: UsersDataClass)

    @Query("SELECT * FROM user WHERE username = :userName")
    suspend fun getUserByUsername(userName: String): UsersDataClass?

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<UsersDataClass>>

    @Delete
    suspend fun deleteUser(user: UsersDataClass)
}