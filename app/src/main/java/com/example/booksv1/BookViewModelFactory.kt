package com.example.booksv1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.booksv1.repository.BookRepository
import com.example.booksv1.viewmodel.BookViewModel

class BookViewModelFactory(private val repository: BookRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookViewModel(repository) as T
    }
}