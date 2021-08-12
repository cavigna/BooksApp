package com.example.booksv1.retrofit

import androidx.lifecycle.MutableLiveData
import com.example.booksv1.BuildConfig
import com.example.booksv1.jsonmodels.modelbestseller.BookNYModel
import com.example.booksv1.jsonmodels.modelbook.LibroModelJson
import com.example.booksv1.jsonmodels.modellong.BookJson
import com.example.booksv1.jsonmodels.modelshort.BookModelJson
import com.example.booksv1.jsonmodels.modelshort.OtroMas
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    companion object{
        const val filtrosGoogle =
            "volumes?fields=kind,items(volumeInfo/title,volumeInfo/authors," +
            "volumeInfo/description,volumeInfo/publishedDate,volumeInfo/imageLinks/thumbnail," +
                    "volumeInfo/canonicalVolumeLink,volumeInfo/previewLink)&printType=books"

        const val urlNyTimes = "https://api.nytimes.com/svc/books/v3/lists/current/" +
                "hardcover-fiction.json?api-key=${BuildConfig.API_KEY}"
    }

    @GET("volumes")
    suspend fun librosPorBusqueda(@Query ("q", encoded = true) palabra:String) :
            Response<BookModelJson?>

    @GET(filtrosGoogle)
    suspend fun searchByQuery(@Query ("q", encoded = true) palabra:String) : Response<LibroModelJson?>

    @GET( urlNyTimes)
    suspend fun bestSellers(): Response<BookNYModel?>



    /********** */

    @GET("volumes?fields=kind,items/volumeInfo/title,items/volumeInfo/authors,items/volumeInfo/description,items/volumeInfo/publishedDate,items/volumeInfo/imageLinks/thumbnail,items/volumeInfo/canonicalVolumeLink,items/volumeInfo/previewLink&printType=books")
    suspend fun pruebabuscar(@Query ("q", encoded = true) palabra:String) : Response<LibroModelJson>

    @GET("volumes")
    suspend fun searchByName(@Query ("q", encoded = true) palabra:String) : Response<BookJson>

//    @GET("volumes")
//    suspend fun searchByQuery(@Query ("q", encoded = true) palabra:String? = null) : Response<BookModelJson>

    @GET("volumes")// => palabra:String? = null ME PERMITE poner el parametro como opcional!  palabra:String? = null
    suspend fun librosPorNombre(@Query ("q", encoded = true) palabra:String) :
            MutableLiveData<Response<BookModelJson>>

    @GET("volumes?q=aleph")
    suspend fun otroMas() : Response<OtroMas.Books2>

    @GET("volumes")
    suspend fun librosConLiveData(@Query ("q", encoded = true) palabra:String) :
            Response<BookModelJson?>


    //suspend fun searchByName(@Query("param1") param1: String ) : Response<BookJson>
}

//https://www.googleapis.com/books/v1/volumes?q=el+aleph


/*
interface RetroService {
    @GET("volumes?q=aleph")
    suspend fun searchByName() : Response<BookJson>
    //suspend fun searchByName(@Query("param1") param1: String ) : Response<BookJson>
}

 */

/*

https://www.googleapis.com/books/v1/volumes?fields=kind,items/volumeInfo/title,items/volumeInfo/authors,items/volumeInfo/description,items/volumeInfo/publishedDate,items/volumeInfo/imageLinks/thumbnail,items/volumeInfo/canonicalVolumeLink,items/volumeInfo/previewLink&printType=books&q=douglas+adams

https://www.googleapis.com/books/v1/volumes?fields=kind,items(volumeInfo/title,volumeInfo/authors,volumeInfo/description,volumeInfo/publishedDate,volumeInfo/imageLinks/thumbnail,volumeInfo/canonicalVolumeLink,volumeInfo/previewLink)&printType=books&q=hobbit

https://www.googleapis.com/books/v1/volumes?fields=kind,items/volumeInfo/title,items/volumeInfo/authors,items/volumeInfo/description,items/volumeInfo/publishedDate,items/volumeInfo/imageLinks/thumbnail,items/volumeInfo/canonicalVolumeLink,items/volumeInfo/previewLink&printType=books&q=hobbit

olumes?fields=kind,items/volumeInfo/title,items/volumeInfo/authors,items/volumeInfo/description,items/volumeInfo/publishedDate,items/volumeInfo/imageLinks/thumbnail,items/volumeInfo/canonicalVolumeLink,items/volumeInfo/previewLink&printType=books
 */