package com.example.appcattrilha

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.appcattrilha.databinding.LayoutBottomSheetBinding
import com.example.appcattrilha.db.AppDatabase
import com.example.appcattrilha.db.login.ActionBottomViewModel
import com.example.appcattrilha.db.registration.RegistrationViewModel
import com.example.appcattrilha.db.repository.UserDbDataSource
import com.example.appcattrilha.db.repository.UserRepository
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ActionBottomDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: LayoutBottomSheetBinding
    private val viewModel : ActionBottomViewModel by activityViewModels {
        val dataBase = AppDatabase.getDatabase(requireActivity())
        val userRepository: UserRepository = UserDbDataSource(dataBase.userDao())
        ActionBottomViewModel.ActionBottomViewModelFactory(userRepository)
    }

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

        lifecycleScope.launchWhenStarted {
            val user = viewModel.getUser()
            binding.nomeCompleto.text = user?.name
            binding.username.text = user?.username
            binding.emailClient.text = user?.email
        }

        return binding.root
    }
}