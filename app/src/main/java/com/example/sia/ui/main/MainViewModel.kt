package com.example.sia.ui.main

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.sia.di.DaggerAppComponent
import javax.inject.Inject


class MainViewModel: ViewModel() {
    @Inject
    lateinit var movieRepository: MovieRepository

    init {
        Log.d(ContentValues.TAG, "noor init viemodel: ")
        DaggerAppComponent.create().inject(this)
        movieRepository.getFakeMovies()
    }

}