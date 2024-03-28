package com.example.movie.di.dao

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GenreRepository @Inject constructor(private var genreDao:GenreDao) {

    /*LiveData nesnesi olarak tanımlanmış,veriler değişebilir bu yüzden val.
    Diğerle fonksiyonlar ekleme işlemi gerçekleştirir,geriye değer döndürmez
    bu yüzden fun
    */



    val readAllData:LiveData<List<GenreData>> = genreDao.readAllData()

    fun addGenre(genreData: GenreData){
        genreDao.addGenre(genreData)
    }
    fun addAllGenres(genreList:List<GenreData>){
        genreDao.addAllGenres(genreList)
    }
}