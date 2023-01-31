package com.inkrodriguez.login.Dao

import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Query("UPDATE UserEntity SET username = :username, password = :password, fullname = :fullname, ocupation = :ocupation, biography = :biography  WHERE username = :username")
    suspend fun update(username: String, password: String, fullname: String, ocupation: String, biography: String)

    @Query("SELECT * FROM UserEntity WHERE username = :username AND password = :password")
    suspend fun authenticationUser(username: String, password: String): UserEntity

    @Query("SELECT * FROM UserEntity WHERE username = :username")
    suspend fun searchUser(username: String): UserEntity

    @Delete
    suspend fun deleteUser(user: UserEntity)


}
