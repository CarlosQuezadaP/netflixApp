package com.instaleap.netflixapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.netflixapp.ISelectGenre
import com.instaleap.netflixapp.adapters.ListActivityAdapter
import com.instaleap.netflixapp.databinding.ActivityListBinding
import com.instaleap.netflixapp.viewmodels.GenresMovieViewModel
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val DATA_ID = "ID"
private const val DATA_NAME = "GENRE_NAME"

class ListActivity : AppCompatActivity(), ISelectGenre {

    private val genresMovieViewModel: GenresMovieViewModel by viewModel()
    private lateinit var activityListBinding: ActivityListBinding
    private lateinit var listActivityAdapter: ListActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        activityListBinding = ActivityListBinding.inflate(layoutInflater)
        setContentView(activityListBinding.root)

        setAdapter()
        getAllGenres()

        imageButtonClose.setOnClickListener {
            finish()
        }
    }

    private fun setAdapter() {
        listActivityAdapter = ListActivityAdapter(this)
        activityListBinding.recyclerViewList.adapter = listActivityAdapter
    }

    private fun getAllGenres() {
        genresMovieViewModel.moviesGenres.observe(this@ListActivity, {
            listActivityAdapter.submitList(it)
        })
    }

    override fun selectGenre(genreItemDomain: GenreItemDomain) {
        val genre = genreItemDomain
        val intent = Intent()
        intent.putExtra(DATA_NAME, genre.name)
        intent.putExtra(DATA_ID, genre.id)
        setResult(RESULT_OK, intent)
        finish()
    }


}