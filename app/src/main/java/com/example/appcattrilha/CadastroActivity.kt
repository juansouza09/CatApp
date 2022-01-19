package com.example.appcattrilha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.appcattrilha.databinding.TelaCadastroBinding
import com.example.appcattrilha.db.AppDatabase
import com.example.appcattrilha.db.registration.RegistrationViewModel
import com.example.appcattrilha.db.registration.RegistrationViewParams
import com.example.appcattrilha.db.repository.UserDbDataSource
import com.example.appcattrilha.db.repository.UserRepository

class CadastroActivity : AppCompatActivity() {
    private lateinit var binding :TelaCadastroBinding
    private val viewModel : RegistrationViewModel by viewModels {
        val dataBase = AppDatabase.getDatabase(this)
        val userRepository: UserRepository = UserDbDataSource(dataBase.userDao())
        RegistrationViewModel.RegistrationViewModelFactory(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.cadastroButton.setOnClickListener {

            if (viewModel.isValidProfileData(
                    binding.textNome.editText?.text.toString(),
                    binding.textEmail.editText?.text.toString(),
                    binding.textUsuario.editText?.text.toString(),
                    binding.textSenha.editText?.text.toString()

                )
            ) {
                viewModel.createUser(
                    binding.textNome.editText?.text.toString(),
                    binding.textEmail.editText?.text.toString(),
                    binding.textUsuario.editText?.text.toString(),
                    binding.textSenha.editText?.text.toString()
                )
                startActivity(Intent(this, HomeActivity::class.java))
            }
            else {
                Toast.makeText(this, "Preencha todos os dados corretamente", Toast.LENGTH_LONG).show()            }
        }

        binding.cancelarButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}/*
viewModel.saveData(
userDao = UserDao.userDao,
binding.textNome.editText?.text.toString(),
binding.textEmail.editText?.text.toString(),
binding.textUsuario.editText?.text.toString(),
binding.textSenha.editText?.text.toString()
)*/