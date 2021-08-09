package com.example.booksv1.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {


    private  val _titulO = MutableLiveData<String>().apply {


        //value =
    }

    val titulO : LiveData<String> = _titulO
}