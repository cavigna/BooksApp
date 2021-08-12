package com.example.booksv1.db

import android.graphics.Bitmap
import android.icu.text.CaseMap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoritos")
data class LibroEntity(



    var title: String?=null,

    var autor : String?=null,

    var fecha: String?=null,

    var descripcion : String,

    var imagen : Bitmap?=null,

    var urlLink: String?=null,

    var helper: String?=null,

    var otros : String?=null,

    ){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}