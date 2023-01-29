package com.inkrodriguez.login.Dao

import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Query("SELECT * FROM UserEntity WHERE username = :username AND password = :password")
    suspend fun authenticationUser(username: String, password: String): UserEntity

    @Delete
    suspend fun deleteUser(user: UserEntity)


}
