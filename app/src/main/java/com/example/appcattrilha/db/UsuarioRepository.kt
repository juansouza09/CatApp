package com.example.appcattrilha.db

class UsuarioRepository(private val dao : UsuarioDAO) {

    val usuarios = dao.getAllUsuarios()

    suspend fun insert(usuario: Usuario) {
        return dao.insertUsuario(usuario)
    }

    suspend fun update(usuario: Usuario) {
        return dao.updateUsuario(usuario)
    }

    suspend fun delete(usuario: Usuario) {
        return dao.deleteUsuario(usuario)
    }

    suspend fun deleteAll() : Int{
        return dao.deleteAll()
    }
}