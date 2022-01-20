package com.example.appcattrilha.db.registration

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.appcattrilha.Common.Common
import com.example.appcattrilha.databinding.ActivityMainBinding
import com.example.appcattrilha.db.UserEntity
import com.example.appcattrilha.db.dao.UserDao
import com.example.appcattrilha.db.repository.UserDbDataSource
import com.example.appcattrilha.db.repository.UserRepository
import kotlinx.coroutines.launch

class RegistrationViewModel (
    val userRepository : UserRepository
        ): ViewModel() {


    class RegistrationViewModelFactory(private val userRepository: UserRepository) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RegistrationViewModel(userRepository) as T
        }
    }

    fun createUser(name: String, email: String, username: String, password: String){
        viewModelScope.launch {
            userRepository.createUser(RegistrationViewParams(name, username, email, password))
            val userId = userRepository.login(username, password)
                Common.loggedUserId = userId
        }
    }

    fun isValidProfileData(name: String, email: String, username: String, password: String): Boolean {
        return when {
            name.isEmpty() ||
            email.isEmpty() ||
            username.isEmpty() ||
            password.isEmpty() -> false
            else -> true
        }
    }

    /*fun saveData (userDao: UserDao, username: String, name: String, email : String, password : String){
        userDao.save(user = UserEntity(0, username, name, email, password))
    }*/

}