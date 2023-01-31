package com.inkrodriguez.login.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inkrodriguez.login.Dao.AppDataBase
import com.inkrodriguez.login.Dao.UserEntity
import kotlinx.coroutines.launch

class PerfilUserViewModel: ViewModel() {

    private lateinit var context: Context

    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var txtName = MutableLiveData<String>()
    var txtOcupation = MutableLiveData<String>()
    var txtBiography = MutableLiveData<String>()

    fun setContext(context: Context){
        this.context = context
    }


    fun searchData(){
        viewModelScope.launch {
            var entity = UserEntity(username.value.toString())

            var result = AppDataBase(context).getUserDao().searchUser(entity.username)

            txtName.value = result.fullname
            txtOcupation.value = result.ocupation
            txtBiography.value = result.biography
        }
    }

}