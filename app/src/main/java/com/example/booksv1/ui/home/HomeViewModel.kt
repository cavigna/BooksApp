package com.example.booksv1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksv1.jsonmodels.modelbestseller.BookNYModel
import com.example.booksv1.jsonmodels.modelshort.BookModelJson
import com.example.booksv1.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(val repository: BookRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        //value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    // ***************** //

    private  var _bestSellersMutableLD: MutableLiveData<BookNYModel?> =
        MutableLiveData<BookNYModel?>()

    val bestSellersLiveData : LiveData<BookNYModel?> get() = _bestSellersMutableLD

    fun bestSellers(){
        viewModelScope.launch(Dispatchers.IO) {
            _bestSellersMutableLD.postValue(repository.bestSellers())
        }
    }
}