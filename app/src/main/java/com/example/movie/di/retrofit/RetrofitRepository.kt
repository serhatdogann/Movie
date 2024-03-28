package com.example.movie.di.retrofit

import androidx.lifecycle.MutableLiveData
import com.example.movie.models.Movie
import com.example.movie.util.Constants.APIKEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private val retrofitServiceInstance: RetrofitServiceInstance)
{
    fun getPopularMovies(apiKey:String,page:String,liveData: MutableLiveData<Movie>){
        retrofitServiceInstance.getPopularVideos(apiKey,page).enqueue(object : Callback<Movie>{
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                liveData.postValue(response.body())
            }
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                liveData.postValue(null)
            }
        })
    }
    fun getRecentlyMovies(apiKey:String,page:String,liveData: MutableLiveData<Movie>){
        retrofitServiceInstance.getRecentlyVideos(apiKey,page).enqueue(object : Callback<Movie>{
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                liveData.postValue(response.body())
            }
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                liveData.postValue(null)
            }
        })
    }


}