package com.inkrodriguez.login

import android.R
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.inkrodriguez.login.databinding.ActivityPerfilUserBinding


class PerfilUser : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val bundle = intent.extras
        val data = bundle!!.getString("username")

        binding.textView2.text = "Olá, $data"

    }
}