package com.example.appcattrilha.db

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity


@Entity(tableName = "Usuario_data_table")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="Descricao_id")
    val id: Int,
    @ColumnInfo(name="Descricao_nome")
    val name: String,
    @ColumnInfo(name="Descricao_senha")
    val senha: String
)