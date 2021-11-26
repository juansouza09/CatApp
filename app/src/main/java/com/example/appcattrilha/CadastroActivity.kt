package com.example.appcattrilha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import com.example.appcattrilha.databinding.TelaCadastroBinding

class CadastroActivity : AppCompatActivity() {
    private lateinit var binding :TelaCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TelaCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cadastroButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.cancelarButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
//startActivity(Intent(this, LoginActivity::class.java))