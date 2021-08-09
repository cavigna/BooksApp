package com.example.booksv1.repository

import androidx.lifecycle.LiveData
import com.example.booksv1.db.LibroDao
import com.example.booksv1.db.LibroEntity
import com.example.booksv1.retrofit.RetroService

class BookRepository(val retroService: RetroService) {

    suspend fun searchByQuery(busqueda: String) = retroService.searchByQuery(busqueda).body()

    suspend fun librosPorNombre(palabra:String) = retroService.librosPorNombre(palabra)

    suspend fun librosPorLiveData(busqueda: String) = retroService.librosConLiveData(busqueda).body()

    suspend fun librosPorBusqueda(busqueda: String) = retroService.librosPorBusqueda(busqueda).body()

    suspend fun bestSellers() = retroService.bestSellers().body()

    // ROOM DB

    inner class RoomRepository(val libroDao: LibroDao){

    suspend fun agregarLibro(libro:LibroEntity) = libroDao.agregarLibro(libro)

    suspend fun eliminarLibro(libro: LibroEntity) = libroDao.eliminarLibro(libro)

    suspend fun deleteAll(libro: LibroEntity) = libroDao.deleteAll()

    val selectAll : LiveData<List<LibroEntity>> = libroDao.selectAll()

    }




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
