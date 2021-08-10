package com.example.booksv1.repository

import androidx.lifecycle.LiveData
import com.example.booksv1.db.LibroDao
import com.example.booksv1.db.LibroEntity
import com.example.booksv1.db.LibrosDB
import com.example.booksv1.retrofit.RetroService
import java.security.AccessController.getContext

class BookRepository(val retroService: RetroService) {

    suspend fun searchByQuery(busqueda: String) = retroService.searchByQuery(busqueda).body()

    suspend fun librosPorNombre(palabra:String) = retroService.librosPorNombre(palabra)

    suspend fun librosPorLiveData(busqueda: String) = retroService.librosConLiveData(busqueda).body()

    suspend fun librosPorBusqueda(busqueda: String) = retroService.librosPorBusqueda(busqueda).body()

    suspend fun bestSellers() = retroService.bestSellers().body()

    // ROOM DB
    //private val libroDao = LibrosDB.getDataBase(getContext()).libroDao()





}


/*
class BookRepository(val retroService: RetroService) {

    suspend fun searchByQuery(busqueda: String) = retroService.searchByQuery(busqueda).body()

    suspend fun librosPorNombre(palabra:String) = retroService.librosPorNombre(palabra)

    suspend fun librosPorLiveData(busqueda: String) = retroService.librosConLiveData(busqueda).body()

    suspend fun librosPorBusqueda(busqueda: String) = retroService.librosPorBusqueda(busqueda).body()

    suspend fun bestSellers() = retroService.bestSellers().body()


}

 */
