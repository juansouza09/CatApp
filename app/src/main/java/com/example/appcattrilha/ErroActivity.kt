package com.example.appcattrilha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.appcattrilha.databinding.TelaErroBinding

class ErroActivity : AppCompatActivity() {

    private lateinit var binding : TelaErroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TelaErroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonVoltar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}