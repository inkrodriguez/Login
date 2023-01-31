package com.inkrodriguez.login.ViewModel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inkrodriguez.login.Dao.AppDataBase
import com.inkrodriguez.login.Dao.UserEntity
import com.inkrodriguez.login.PerfilUser
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private lateinit var context: Context
    var editUsername = MutableLiveData<String>()
    var editPassword = MutableLiveData<String>()

    fun setContext(context: Context){
        this.context = context
    }

    fun authentication() {

        viewModelScope.launch {
            val userEdit = UserEntity(editUsername.value.toString(), editPassword.value.toString())

            val resultAuthentication =
                AppDataBase(context).getUserDao().authenticationUser(userEdit.username, userEdit.password)

            if(resultAuthentication != null ){
                Toast.makeText(context, "Os dados foram conferidos, bem-vindo(a)!", Toast.LENGTH_SHORT).show()
                var intent = Intent(context, PerfilUser::class.java).putExtra("username", resultAuthentication.username).putExtra("password", resultAuthentication.password)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }else{
                Toast.makeText(context, "Usuário ou senha inválidos!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}