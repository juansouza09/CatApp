package com.example.appcattrilha.db.repository

import com.example.appcattrilha.db.model.User
import com.example.appcattrilha.db.registration.RegistrationViewParams

interface UserRepository {

    suspend fun createUser(registrationViewParams: RegistrationViewParams)

    suspend fun getUser(id: Long) : User?

    suspend fun login (username: String, password: String): Long?
}