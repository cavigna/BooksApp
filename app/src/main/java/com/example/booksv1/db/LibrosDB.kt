package com.example.booksv1.db

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.booksv1.utils.Converters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@TypeConverters(Converters::class)
@Database(entities = [LibroEntity::class], version = 1, exportSchema = false)
abstract class LibrosDB : RoomDatabase(){


    abstract  fun libroDao(): LibroDao

    companion object{
        @Volatile
        private var INSTANCE : LibrosDB? = null

        fun getDataBase(context: Context): LibrosDB{
            val temporalInstance = INSTANCE
            if (temporalInstance != null){
                return temporalInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibrosDB::class.java,
                    "libros_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class LibroDataBaseCallBack(
        private val scope : CoroutineScope
    ) : RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database->
                scope.launch {
                    var libroDao = database.libroDao()
                    val converters = Converters()
                    var libro = LibroEntity(
                        "Guía del autoestopista galáctico",
                        "Douglas Adams",
                        "2008-01-07",
                        "Un jueves a la hora de comer, la Tierra es demolida para poder construir una nueva autopista hiperespacial. Arthur Dent, un tipo que esa misma mañana ha visto cómo echaban abajo su propia casa, considera que eso supera lo que una persona puede soportar. Arthur huirá de la Tierra junto a un amigo suyo, Ford Prefect, que resultará ser un extraterrestre emparentado con Zaphod Beeblebrox, un pirata esquizoide de dos cabezas, en cuya nave conocerá al resto de personajes que lo acompañarán: un androide paranoide y una terrícola que, como él, ha logrado escapar. Douglas Adams fue el creador de toda una serie de manifestaciones de la Guía del autoestopista galáctico: primero fue novela radiofónica, luego se convirtió en libro, series televisivas y teatrales, un juego de ordenador, cómics y toallas de baño. La película ascendió hasta las cumbres de la producción cinematográfica. Esta edición cuenta con entrevistas y materiales a partir del rodaje de la misma.",
                        urlLink = "http://books.google.cl/books?id=2GacDQAAQBAJ&printsec=frontcover&dq=douglas+adams&hl=&as_pt=BOOKS&cd=1&source=gbs_api"

                    )

                    libroDao.agregarLibro(libro)


                }
            }
        }
    }

//    private suspend fun  getBitmap(urlImage:String): Bitmap {
//        val loading= ImageLoader(requireContext(this))
//        val request= ImageRequest.Builder(requireContext())
//            .data(urlImage)
//            .build()
//        val result = (loading.execute(request) as SuccessResult).drawable
//        return(result as BitmapDrawable).bitmap
//    }

//    private suspend fun  getBitmap(urlImage:String): Bitmap {
//        val loading= ImageLoader(context = Context)
//        val request= ImageRequest.Builder(requireContext())
//            .data(urlImage)
//            .build()
//        val result = (loading.execute(request) as SuccessResult).drawable
//        return(result as BitmapDrawable).bitmap
//    }


}

/*
val buenosLibros = todosLibros
        .filterNotNull { it.autores }
        .filterNotNull { it.tvtitulo }
        .filterNotNull { it.volumeInfo?.imageLinks?.thumbnail }
 */

