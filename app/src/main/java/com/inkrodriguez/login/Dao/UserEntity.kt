package com.inkrodriguez.login.Dao

import android.widget.ImageView
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.inkrodriguez.login.R

@Entity
class UserEntity (var username: String, var password: String = "", var fullname: String = "", var ocupation: String = "", var biography: String = "") {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}