package com.example.movie.di.dao

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("genres")
data class GenreData (

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val genreid:Int,
    val en_name:String,
    val tr_name:String


        )