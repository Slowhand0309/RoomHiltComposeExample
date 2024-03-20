package com.example.roomhiltcomposeexample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * from users ORDER BY name ASC")
    fun getUsers(): Flow<List<User>>

    @Query("SELECT * from users WHERE id = :id")
    fun getUser(id: Long): Flow<User>

    @Insert
    suspend fun insert(user: User): Long
}