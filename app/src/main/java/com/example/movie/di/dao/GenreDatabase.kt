package com.example.movie.di.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [GenreData::class], version = 1, exportSchema = false)
abstract class GenreDatabase:RoomDatabase() {

    abstract fun getDao():GenreDao

    companion object{

        private var dnINSTANCE:GenreDatabase?=null

        fun getAppdb(context: Context): GenreDatabase? {
            if (dnINSTANCE==null){
                dnINSTANCE= Room.databaseBuilder(context,GenreDatabase::class.java,"genre_database")
                    .build()

            }
            return dnINSTANCE
        }
    }
}