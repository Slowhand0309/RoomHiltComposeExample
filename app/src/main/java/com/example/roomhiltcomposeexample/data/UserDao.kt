package com.example.roomhiltcomposeexample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * from users WHERE id = :id")
    fun getUser(id: Int): Flow<User>

    @Insert
    suspend fun insert(user: User)
}