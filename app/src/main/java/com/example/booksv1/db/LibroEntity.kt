package com.example.booksv1.db

import android.icu.text.CaseMap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoritos")
data class LibroEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    val title: String,
    val autor : String,
    val fecha: String,
    val descripcion : String,
    val urlLink: String





    )