package com.example.appcattrilha

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil.setContentView
import com.example.appcattrilha.databinding.LayoutBottomSheetBinding
import com.example.appcattrilha.databinding.TelaLoginBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.btn_coracao as btn_coracao1

class ActionBottomDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: LayoutBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutBottomSheetBinding.inflate(layoutInflater, container, false)
        binding.btnCoracao.setOnClickListener {
            startActivity(Intent(requireContext(), FavoritoActivity::class.java))
            dismiss()
        }

        binding.btnExit.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            dismiss()
        }

        return binding.root
    }

}