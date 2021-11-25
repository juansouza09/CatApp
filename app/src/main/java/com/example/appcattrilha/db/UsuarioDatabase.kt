/*package com.example.appcattrilha.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Usuario::class], version =1 )
abstract class UsuarioDatabase : RoomDatabase(){
    abstract val usuarioDAO : UsuarioDAO
    companion object {
        @Volatile
        private var INSTANCE: UsuarioDatabase? = null
        fun getInstance(context: Context) : UsuarioDatabase {
            synchronized(lock:this){
                var instance : UsuarioDatabase? = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UsuarioDatabase::class.java,
                        name:"usuario_data_database"
                    ).build()
                }
                return instance
            }
        }

    }
}*/