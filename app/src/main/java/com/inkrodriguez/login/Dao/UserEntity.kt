package com.inkrodriguez.login.Dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserEntity (var username: String, var password: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}