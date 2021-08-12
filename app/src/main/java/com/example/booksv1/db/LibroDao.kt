package com.example.booksv1.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface LibroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarLibro(libro: LibroEntity)

    @Delete
    suspend fun eliminarLibro(libro: LibroEntity)

    @Query("DELETE  FROM favoritos")
    suspend fun deleteAll()

    @Query("SELECT * FROM favoritos")
     fun selectAll() : LiveData<List<LibroEntity>>







}