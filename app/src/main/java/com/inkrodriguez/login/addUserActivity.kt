package com.inkrodriguez.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.inkrodriguez.login.Dao.AppDataBase
import com.inkrodriguez.login.Dao.UserEntity
import com.inkrodriguez.login.databinding.ActivityAddUserBinding
import kotlinx.coroutines.launch

class addUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()



        binding.button.setOnClickListener {
            addUser()
        }


    }

    fun addUser() {
        var user = binding.editUsernameRegister.text.toString()
        var pass = binding.editPasswordRegister.text.toString()
        var entity = UserEntity(user, pass)

        lifecycleScope.launch {
            AppDataBase(this@addUserActivity).getUserDao().addUser(entity)
            Toast.makeText(this@addUserActivity, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}