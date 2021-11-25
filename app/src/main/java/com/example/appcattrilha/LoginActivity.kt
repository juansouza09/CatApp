package com.example.appcattrilha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.appcattrilha.databinding.TelaLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding : TelaLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.criarContaButton.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

        binding.entrarButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }


    }
}