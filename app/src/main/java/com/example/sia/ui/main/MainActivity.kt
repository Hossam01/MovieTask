package com.example.sia.ui.main


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.sia.di.DaggerAppComponent
import com.example.sia.ui.adapter.MovieAdapter
import com.example.sia.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var movieAdapter: MovieAdapter

    @Inject
    lateinit var gson: Gson


    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent.create().inject(this)

        setUpRecyclerView()

        observeIsError()
        observeMovieList()


    }

    private fun observeMovieList() {
        viewModel.movieRepository.data.observe(this, Observer {
            movieAdapter.setContextAdapter(this)
            movieAdapter.setMovies(it)
        })
    }

    private fun observeIsError() {
        viewModel.movieRepository.isError.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }


    private fun setUpRecyclerView() {

        movie_recyclerView.apply {
            hasFixedSize()
            adapter = movieAdapter

        }

    }


    fun updateMovies() {
        movieAdapter.notifyDataSetChanged()
    }
}