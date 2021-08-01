package com.example.booksv1.repository

import com.example.booksv1.retrofit.RetroService

class BookRepository(val retroService: RetroService) {
    suspend fun searchByQuery() = retroService.searchByQuery()
    suspend fun librosPorNombre() = retroService.librosPorNombre()
//suspend fun searchByName() = retroService.searchByName()
}