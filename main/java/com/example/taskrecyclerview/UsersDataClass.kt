package com.example.taskrecyclerview

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")

data class UsersDataClass(

    @get:Bindable
    @PrimaryKey var userName: String,

    @get:Bindable
    var password: String
): BaseObservable()