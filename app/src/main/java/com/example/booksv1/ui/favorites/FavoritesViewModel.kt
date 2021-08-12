package com.example.booksv1.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksv1.db.LibroEntity
import com.example.booksv1.repository.DBRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class FavoritesViewModel(private val dbRepository: DBRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        //value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text


    /* ************* */

    private val _librosFavoritos:MutableLiveData<List<LibroEntity>>
                = MutableLiveData<List<LibroEntity>>()
    val librosFavoritos = _librosFavoritos

    val allLibros = dbRepository.selectAll

//    fun allLibros(){
//        viewModelScope.launch(IO) {
//
//        }
//    }


}




/*

class FavoritesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        //value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text


    /* ************* */


}




 */