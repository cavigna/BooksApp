package com.example.booksv1.repository

import androidx.lifecycle.LiveData
import com.example.booksv1.db.LibroDao
import com.example.booksv1.db.LibroEntity

class DBRepository(val libroDao: LibroDao) {
    suspend fun agregarLibro(libro: LibroEntity) = libroDao.agregarLibro(libro)

    suspend fun eliminarLibro(libro: LibroEntity) = libroDao.eliminarLibro(libro)

    suspend fun deleteAll(libro: LibroEntity) = libroDao.deleteAll()

    val selectAll : LiveData<List<LibroEntity>> = libroDao.selectAll()
}