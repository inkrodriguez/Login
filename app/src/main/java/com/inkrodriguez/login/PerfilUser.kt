package com.inkrodriguez.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.inkrodriguez.login.Dao.AppDataBase
import com.inkrodriguez.login.Dao.UserEntity
import com.inkrodriguez.login.ViewModel.PerfilUserViewModel
import com.inkrodriguez.login.databinding.ActivityPerfilUserBinding
import kotlinx.coroutines.launch


class PerfilUser : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilUserBinding
    private lateinit var viewModel: PerfilUserViewModel

    override fun onResume() {
        super.onResume()
        //Nesse ciclo de vida, ele executa o metódo toda vez que entra em OnPause.
        viewModel.searchData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this)[PerfilUserViewModel::class.java]
        viewModel.setContext(applicationContext)

        var username = intent.extras?.get("username").toString()
        var password = intent.extras?.get("password").toString()

        viewModel.username.value = username

        binding.txtUsername.text = "Olá, $username"

        viewModel.txtName.observe(this, Observer {
                binding.txtName.text = (it.toString())
        })

        viewModel.txtOcupation.observe(this, Observer {
            binding.txtOcupation.text = it.toString()
        })
        viewModel.txtBiography.observe(this, Observer {
            binding.txtBiography.text = it.toString()
        })



        binding.imgLogout.setOnClickListener {
            finish()
        }

        binding.imgConfig.setOnClickListener{
            startActivity(Intent(baseContext, editUserActivity::class.java).putExtra("username", "$username").putExtra("password", "$password"))
        }

    }

}