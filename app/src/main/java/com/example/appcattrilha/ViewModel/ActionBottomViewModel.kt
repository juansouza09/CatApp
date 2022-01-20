package com.example.appcattrilha.db.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appcattrilha.Common.Common
import com.example.appcattrilha.db.model.User
import com.example.appcattrilha.db.registration.RegistrationViewModel
import com.example.appcattrilha.db.registration.RegistrationViewParams
import com.example.appcattrilha.db.repository.UserRepository
import kotlinx.coroutines.launch

class ActionBottomViewModel (
    val userRepository: UserRepository
) : ViewModel(){

    class ActionBottomViewModelFactory(private val userRepository: UserRepository) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ActionBottomViewModel(userRepository) as T
        }
    }

    suspend fun getUser() : User?{
       return userRepository.getUser(Common.loggedUserId ?: 0)

    }

}