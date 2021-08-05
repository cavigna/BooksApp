package com.example.booksv1.viewmodel

import androidx.lifecycle.*
import com.example.booksv1.jsonmodels.modelshort.BookModelJson
import com.example.booksv1.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Response

class BookViewModel(val repository: BookRepository) : ViewModel() {
    private var _librosMutableLiveData: MutableLiveData<BookModelJson?> =
        MutableLiveData<BookModelJson?>() //==> Esto solo es una abstracción para que el observer solo
    //interactue con el getter de abajo

    val librosMutableLiveData: LiveData<BookModelJson?> get() = _librosMutableLiveData



    fun librosPorBusqueda(busqueda: String) {
        viewModelScope.launch(IO) {
            _librosMutableLiveData.postValue(repository.librosPorBusqueda(busqueda))

        }
    }

}


/*
var _fafafa: MutableLiveData<BookModelJson?> =
    MutableLiveData<BookModelJson?>()
val fafafa: LiveData<BookModelJson?> get() = _fafafa

     fun getFafafa(userId:String) {
     viewModelScope.launch(Dispatchers.IO){
         _fafafa.postValue(repository.librosPorLiveData(userId))
        // _fafafa.value = repository.librosPorLiveData(userId).value
     }


}
 */

//     suspend fun librosPorNombre(palabra: String): MutableLiveData<Response<BookModelJson>> {
//         //mpalabra = palabra
//
//
//        librosMutableLiveData = repository.librosPorNombre(palabra)
//
//         return librosMutableLiveData
//     }


/*
  suspend fun librosPorNombre(palabra : String) = CoroutineScope(Dispatchers.IO).launch{

    repository.librosPorNombre(palabra)
}
 */


//val booksLists: LiveData<BookModelJson>

//val librosPorNombre :LiveData<Response<BookModelJson>> = repository.librosPorNombre.asLiveData()
/*
suspend fun librosPorNombre(): LiveData<Response<BookModelJson>> =
     repository.librosPorNombre()
*/

/*
    suspend fun librosPorNombre(): LiveData<Response<BookModelJson>> {
        val libros = viewModelScope.launch {
            withContext(Dispatchers.IO){
                 repository.librosPorNombre()
            }

        }
        librosLiveData.postValue(libros)
        return repository.librosPorNombre()
    }
 */

/*
    suspend fun librosListado(palabra:String): MutableLiveData<Response<BookModelJson>>{
        val libros = viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.librosPorNombre(palabra)
            }

        }
        librosLiveData.postValue(libros)
        return repository.librosPorNombre(palabra)
    }
 */

/*
    suspend fun librosListado(palabra:String): MutableLiveData<Response<BookModelJson>>{
        val libros = viewModelScope.launch {
            withContext(Dispatchers.IO){
                val response = repository.librosPorNombre(palabra)
               // response.value = librosLiveData
            }

        }
        //librosLiveData.postValue(libros)
        return repository.librosPorNombre(palabra)
    }
 */

/*
class BookViewModel(val repository: BookRepository) : ViewModel() {
    var librosMutableLiveData = MutableLiveData<Response<BookModelJson>>()
    var _fafafa: MutableLiveData<Response<BookModelJson?>> =
        MutableLiveData<Response<BookModelJson?>>()

    var librosMutableLiveData2 = MutableLiveData<Response<BookModelJson>>()

    //var librosLiveData = LiveData<BookModelJson>



    val result: MutableLiveData<Response<BookModelJson>> get() = librosMutableLiveData
    val fafafa: MutableLiveData<Response<BookModelJson?>> get() = _fafafa


     fun getFafafa(userId:String) {
         viewModelScope.launch(Dispatchers.IO){
             //_fafafa.postValue(repository.librosPorLiveData(userId))
             _fafafa.value = repository.librosPorLiveData(userId).value
         }


    }

     suspend fun librosPorNombre(palabra: String): MutableLiveData<Response<BookModelJson>> {
         //mpalabra = palabra


        librosMutableLiveData = repository.librosPorNombre(palabra)

         return librosMutableLiveData
     }

     fun librosPorNombre2(text: String) =
        viewModelScope.launch(Dispatchers.IO) {
            librosMutableLiveData.postValue(repository.librosPorNombre(text).value)

        //librosLiveData = repository.librosPorNombre(text)
            //librosMutableLiveData.postValue(repository.librosPorNombre(text).value)
            //librosLiveData.setValue(repository.librosPorNombre(text).value)
            //librosMutableLiveData.postValue(repository.librosPorNombre(text))
        }
 */