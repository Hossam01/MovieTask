package com.example.sia.di

import com.example.sia.data.networks.ApiService
import com.example.sia.data.networks.ApiServiceFactory
import com.example.sia.model.MovieModel
import com.example.sia.ui.main.MainViewModel
import com.example.sia.ui.main.MovieRepository
import com.example.sia.ui.adapter.MovieAdapter
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideApi(): ApiService = ApiServiceFactory.getInstance()

    @Provides
    fun provideViewModel(): MainViewModel = MainViewModel()

    @Provides
    fun provideMovieRepository(): MovieRepository = MovieRepository()

    @Provides
    fun provideGson() = Gson()

    @Provides
    fun provideMovieList() = MovieModel()

    @Provides
    fun provideMovieAdapter(movieList: MovieModel): MovieAdapter =
        MovieAdapter(movieList)
}