package com.example.roomhiltcomposeexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String = "",
    var image: String
)
