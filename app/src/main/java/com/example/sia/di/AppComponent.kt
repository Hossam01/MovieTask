package com.example.sia.di

import com.example.sia.ui.main.MainActivity
import com.example.sia.ui.main.MainViewModel
import com.example.sia.ui.main.MovieRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(mainViewModel: MainViewModel)

    fun inject(movieRepository: MovieRepository)
}