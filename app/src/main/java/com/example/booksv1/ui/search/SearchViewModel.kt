package com.example.booksv1.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksv1.jsonmodels.modelbook.LibroModelJson
import com.example.booksv1.repository.BookRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class SearchViewModel(val repository: BookRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        //value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private var _librosMutableLiveData : MutableLiveData<LibroModelJson?> =
        MutableLiveData<LibroModelJson?>()
    val librosLiveData : LiveData<LibroModelJson?> = _librosMutableLiveData

    fun searchByQuery(busqueda:String){
        viewModelScope.launch (IO){
            _librosMutableLiveData.postValue(repository.searchByQuery(busqueda))
        }
    }
}

//https://www.googleapis.com/books/v1/volumes?projection=lite&printType=books&q=el+aleph

//https://www.googleapis.com/books/v1/volumes?projection=lite&printType=books&q=el+aleph&fields=kind,items(volumeInfo/title,volumeInfo/authors)
//
//https://www.googleapis.com/books/v1/volumes?fields=kind,items(volumeInfo/title,volumeInfo/authors,volumeInfo/description,volumeInfo/publishedDate,volumeInfo/imageLinks/thumbnail,volumeInfo/canonicalVolumeLink,volumeInfo/previewLink)&printType=books&q=el+aleph

/*
libro/publishedDate
libro/description
libro/imageLinks/thumbnail
libro/canonicalVolumeLink
libro/previewLink



 */