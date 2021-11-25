package com.example.appcattrilha.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UsuarioDAO {
    @Insert
    suspend fun insertUsuario(usuario:Usuario)

    @Update
    suspend fun updateUsuario(usuario:Usuario)

    @Delete
    suspend fun deleteUsuario(usuario:Usuario)

    @Query("DELETE FROM usuario_data_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM usuario_data_table")
    fun getAllUsuarios(): LiveData<List<Usuario>>
}