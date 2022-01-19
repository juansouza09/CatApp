package com.example.appcattrilha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.appcattrilha.databinding.TelaLoginBinding
import com.example.appcattrilha.db.AppDatabase
import com.example.appcattrilha.db.login.LoginViewModel
import com.example.appcattrilha.db.registration.RegistrationViewModel
import com.example.appcattrilha.db.repository.UserDbDataSource
import com.example.appcattrilha.db.repository.UserRepository


class LoginActivity : AppCompatActivity() {

    private lateinit var binding : TelaLoginBinding
    private val viewModel : LoginViewModel by viewModels {
        val dataBase = AppDatabase.getDatabase(this)
        val userRepository: UserRepository = UserDbDataSource(dataBase.userDao())
        LoginViewModel.LoginViewModelFactory(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.criarContaButton.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

        binding.entrarButton.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                val sucesso = viewModel.login(
                    binding.textUsuario.editText?.text.toString(),
                    binding.textSenha.editText?.text.toString()
                )
                if (sucesso) {
                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                }
                else startActivity(Intent(this@LoginActivity, ErroActivity::class.java))
            }
        }
    }
}