package com.inkrodriguez.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.inkrodriguez.login.Dao.AppDataBase
import com.inkrodriguez.login.Dao.UserEntity
import com.inkrodriguez.login.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.tvInfoRegistro.setOnClickListener {
            startActivity(Intent(this, addUserActivity::class.java))
        }

        binding.btnSignIn.setOnClickListener {
            authentication()
        }


    }

    fun authentication() {
        lifecycleScope.launch {
            val editUsername = binding.editUsername.text.toString()
            val editPassword = binding.editPassword.text.toString()
            val userEdit = UserEntity(editUsername, editPassword)
            val resultAuthentication =
                AppDataBase(this@MainActivity).getUserDao().authenticationUser(userEdit.username, userEdit.password)

            if(resultAuthentication != null ){
                Toast.makeText(this@MainActivity, "Os dados foram conferidos, bem-vindo(a)!", Toast.LENGTH_SHORT).show()

                startActivity(Intent(applicationContext, PerfilUser::class.java).putExtra("username", resultAuthentication.username))


            }else{
                Toast.makeText(this@MainActivity, "Os dados não existem!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}