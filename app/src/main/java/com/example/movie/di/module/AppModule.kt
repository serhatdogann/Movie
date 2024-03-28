package com.example.movie.di.module

import android.content.Context
import com.example.movie.di.dao.GenreDao
import com.example.movie.di.dao.GenreDatabase
import com.example.movie.di.retrofit.RetrofitServiceInstance
import com.example.movie.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getappDB(contex:Context):GenreDatabase?{
        return GenreDatabase.getAppdb(contex)
    }


    @Provides
    @Singleton
    fun getDao(appdb:GenreDatabase):GenreDao{
        return appdb.getDao()
    }


    @Provides
    @Singleton
    fun getRetrofitInstance(retrofit: Retrofit): RetrofitServiceInstance {
        return retrofit.create(RetrofitServiceInstance::class.java)
    }

    @Provides
    @Singleton
    fun getRetroInstance():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


}