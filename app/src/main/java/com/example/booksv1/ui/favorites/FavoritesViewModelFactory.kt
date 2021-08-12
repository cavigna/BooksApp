package com.example.booksv1.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.booksv1.repository.DBRepository

class FavoritesViewModelFactory(private val dbRepository: DBRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavoritesViewModel(dbRepository) as T
        //return FavoritesViewModel(dbRepository) as T
    }
}