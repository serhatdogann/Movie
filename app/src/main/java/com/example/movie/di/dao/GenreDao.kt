package com.example.movie.di.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GenreDao {

    @Insert
    fun addGenre(genre:GenreData)

    @Insert
    fun addAllGenres(genres:List<GenreData>)

    @Query("SELECT * FROM genres")
    fun readAllData():LiveData<List<GenreData>>


}