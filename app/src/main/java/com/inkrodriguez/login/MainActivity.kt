package com.inkrodriguez.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.inkrodriguez.login.ViewModel.MainViewModel
import com.inkrodriguez.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
        viewModel.setContext(applicationContext)


        binding.tvInfoRegistro.setOnClickListener {
            startActivity(Intent(this@MainActivity, addUserActivity::class.java))
        }

        binding.btnSignIn.setOnClickListener {
            viewModel.editUsername.value = binding.editUsername.text.toString()
            viewModel.editPassword.value = binding.editPassword.text.toString()
            viewModel.authentication()
        }
    }
}