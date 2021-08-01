package com.example.booksv1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.booksv1.jsonmodels.modelshort.BookModelJson
import com.example.booksv1.repository.BookRepository
import retrofit2.Response

class BookViewModel(val repository: BookRepository) : ViewModel() {
    //val booksLists: LiveData<BookModelJson>

    suspend fun librosPorNombre(): LiveData<Response<BookModelJson>> =
         repository.librosPorNombre()

}