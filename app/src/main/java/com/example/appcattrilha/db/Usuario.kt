package com.example.appcattrilha.db

import androidx.room.PrimaryKey
import androidx.room.Entity
import com.example.appcattrilha.db.model.User
import com.example.appcattrilha.db.registration.RegistrationViewParams


@Entity(tableName = "user")
data class UserEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val username: String,
    val name: String,
    val email : String,
    val password: String
)

fun RegistrationViewParams.toUserEntity(): UserEntity{
    return with(this) {
        UserEntity(
            name = this.name,
            username = this.username,
            email = this.email,
            password = this.password
        )
    }
}

fun UserEntity.toUser(): User {
    return User(
        id = this.id.toString(),
        name = this.name,
        email = this.email
    )
}