package com.inkrodriguez.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.inkrodriguez.login.Dao.AppDataBase
import com.inkrodriguez.login.Dao.UserEntity
import com.inkrodriguez.login.databinding.ActivityEditUserBinding
import kotlinx.coroutines.launch

class editUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditUserBinding
    private lateinit var viewModel: editUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityEditUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        viewModel = ViewModelProvider(this)[editUserViewModel::class.java]

        viewModel.setContext(applicationContext)

        var username = intent.extras?.get("username").toString()
        viewModel.username.value = intent.extras?.get("username").toString()
        var password = intent.extras?.get("password").toString()
        viewModel.password.value = intent.extras?.get("password").toString()


        viewModel.setData()

        binding.editUsernameEdit.setText(username)
        binding.editPasswordEdit.setText(password)

        viewModel.editFullnameEdit.observe(this, Observer {
                binding.editFullnameEdit.setText(it.toString())
        })

        viewModel.editOcupationEdit.observe(this, Observer {
            binding.editOcupationEdit.setText(it.toString())
        })

        viewModel.editBiographyEdit.observe(this, Observer {
            binding.editBiographyEdit.setText(it.toString())
        })



        binding.button6.setOnClickListener {
            update()
        }

    }

    fun update(){
        var userEdit = binding.editUsernameEdit.text.toString()
        var passEdit = binding.editPasswordEdit.text.toString()
        var fullnameEdit = binding.editFullnameEdit.text.toString()
        var ocupationEdit = binding.editOcupationEdit.text.toString()
        var biographyEdit = binding.editBiographyEdit.text.toString()

        var userEntity = UserEntity(userEdit, passEdit, fullnameEdit, ocupationEdit, biographyEdit)

        lifecycleScope.launch {
            AppDataBase(this@editUserActivity).getUserDao().update(userEntity.username, userEntity.password, userEntity.fullname, userEntity.ocupation, userEntity.biography)
            Toast.makeText(this@editUserActivity, "Usuário alterado! ${userEntity.username}", Toast.LENGTH_SHORT).show()
            finish()
        }
    }


}