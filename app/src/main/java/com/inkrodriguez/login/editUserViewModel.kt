package com.inkrodriguez.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inkrodriguez.login.Dao.AppDataBase
import com.inkrodriguez.login.Dao.UserEntity
import kotlinx.coroutines.launch

class editUserViewModel: ViewModel() {
    private lateinit var context: Context

    fun setContext(context: Context){
        this.context = context
    }

    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var editFullnameEdit = MutableLiveData<String>()
    var editOcupationEdit = MutableLiveData<String>()
    var editBiographyEdit = MutableLiveData<String>()
    var fullname = ""
    var ocupation = ""
    var biography = ""



    fun setData() {
        viewModelScope.launch {
            var entity = UserEntity(username.value.toString())
            var result = AppDataBase(context).getUserDao().searchUser(entity.username)

            editFullnameEdit.value = result.fullname
            editOcupationEdit.value = result.ocupation
            editBiographyEdit.value = result.biography
        }
    }


}