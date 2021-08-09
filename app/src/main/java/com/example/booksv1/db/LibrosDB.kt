package com.example.booksv1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.booksv1.ui.home.HomeFragment



@Database(entities = [LibroEntity::class], version = 1)
abstract class LibrosDB : RoomDatabase(){


    abstract  fun libroDao(): LibroDao

    companion object{
        @Volatile
        private var INSTANCE : LibrosDB? = null

        fun getDataBase(context: HomeFragment): LibrosDB{
            val temporalInstance = INSTANCE
            if (temporalInstance != null){
                return temporalInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.requireContext(),
                    LibrosDB::class.java,
                    "libros_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}