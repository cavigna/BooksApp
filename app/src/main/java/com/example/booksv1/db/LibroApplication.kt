package com.example.booksv1.db

import android.app.Application
import com.example.booksv1.repository.DBRepository
import com.example.booksv1.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/*
You want to have only one instance of the database and of the repository in your app.
 An easy way to achieve this is by creating them as members of the Application class.
 Then they will just be retrieved from the Application whenever they're needed, rather than
 constructed every time.
 */
class LibroApplication:Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { LibrosDB.getDataBase(this) }

    val dbRepository by lazy{ database.libroDao()}

    val retroService by lazy{ RetrofitInstance}


    val repositoryApi by lazy { retroService }

}