package com.example.booksv1.repository

import com.example.booksv1.retrofit.RetroService

class BookRepository(val retroService: RetroService) {
    suspend fun searchByQuery() = retroService.searchByQuery()
    suspend fun librosPorNombre(palabra:String) = retroService.librosPorNombre(palabra)

    suspend fun librosPorLiveData(busqueda: String) = retroService.librosConLiveData(busqueda).body()

    suspend fun librosPorBusqueda(busqueda: String) = retroService.librosPorBusqueda(busqueda).body()


}

//    suspend fun librosPorNombrePrueba(busqueda: String){
//        val request = retroService.librosPorNombre(busqueda)
//        if (request.)
//    }
//suspend fun searchByName() = retroService.searchByName()