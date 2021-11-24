package com.example.appcattrilha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.tela_home.*


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_home)

        topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
        openBottomSheet() // abre o Bottom sheet quando clica no menu

        }
            topAppBar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.search -> {
                        // Handle search icon press
                        true
                    }
                    else -> false
                }
            }
        }

    fun openBottomSheet(){
        val addBottomSheetFragment = ActionBottom.newInstance()
        addBottomSheetFragment.show(
            supportFragmentManager, ActionBottom.TAG
        )
    }
    }