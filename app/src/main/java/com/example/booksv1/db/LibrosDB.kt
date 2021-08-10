package com.example.booksv1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [LibroEntity::class], version = 1)
abstract class LibrosDB : RoomDatabase(){


    abstract  fun libroDao(): LibroDao

    companion object{
        @Volatile
        private var INSTANCE : LibrosDB? = null

        fun getDataBase(context: Context): LibrosDB{
            val temporalInstance = INSTANCE
            if (temporalInstance != null){
                return temporalInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibrosDB::class.java,
                    "libros_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}