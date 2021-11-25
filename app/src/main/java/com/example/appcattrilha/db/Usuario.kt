package com.example.appcattrilha.db

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity


@Entity(tableName = "Usuario_data_table")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="descricao_id")
    val id: Int,
    @ColumnInfo(name="descricao_usuario")
    val usuario_name: String,
    @ColumnInfo(name="descricao_nome")
    val name: String,
    @ColumnInfo(name="descricao_email")
    val email : String,
    @ColumnInfo(name="descricao_senha")
    val senha: String
)