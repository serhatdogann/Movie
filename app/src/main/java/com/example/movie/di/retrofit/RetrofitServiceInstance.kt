package com.example.movie.di.retrofit

import com.example.movie.models.Genre
import com.example.movie.models.Movie
import com.example.movie.models.Trailer
import com.example.movie.util.Constants.APIKEY
import com.example.movie.util.Constants.BASE_URL
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServiceInstance {

    // https://api.themoviedb.org/3/movie/popular?api_key=6111d4664d987e90a5b9de3f2aae625e
    // https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1

    @GET("3/movie/popular")
    fun getPopularVideos(
        @Query("api_key")apiKey: String,
        @Query("page")query:String):Call<Movie>

    @GET("3/movie/now_playing")
    fun getRecentlyVideos(
        @Query("api_key")apiKey:String,
        @Query("page")query:String):Call<Movie>

    @GET("3/genre/movie/list")
    fun getGenres():Call<Genre>

    @GET("3/movie/{id}videos")
    fun getTrailerTeasers(
        @Path("id")id:Int):Call<Trailer>

    @GET("3/search/movie/")
    fun getSuggestion(
        @Query("api_key")apiKey: String,
        @Query("query")query: String):Call<Movie>




}
