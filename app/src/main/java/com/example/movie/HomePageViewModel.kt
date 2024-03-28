package com.example.movie

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.di.retrofit.RetrofitRepository
import com.example.movie.models.Movie
import com.example.movie.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor (var repository: RetrofitRepository): ViewModel() {
    // ViewModel'in başlatılmasına yönelik işlemler buraya eklenebilir


    var popularMovieList: MutableLiveData<Movie>
    var recentMovielist: MutableLiveData<Movie>

     init {
         popularMovieList= MutableLiveData()
         recentMovielist= MutableLiveData()
     }
    fun getObserverLiveData(isPopular:Boolean):MutableLiveData<Movie>{
        if (isPopular)
            return popularMovieList
        else
            return recentMovielist
    }
    fun loadPopularLiveData(isPopular: Boolean,apiKey:String,page:String){
        if (isPopular){
            return repository.getPopularMovies(apiKey,"2",popularMovieList)
        }
        else{
            return repository.getRecentlyMovies(apiKey,"3",recentMovielist)
        }
    }
}