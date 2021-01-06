package com.instaleap.dato

import com.instaleap.dato.responses.discoverMovie.DiscoverMovieResponse
import com.instaleap.dato.responses.discoverTv.DiscoverTvResponse
import com.instaleap.dato.responses.genresMovies.GenresMoviesResponse
import com.instaleap.dato.responses.genresTV.GenresTVResponse
import com.instaleap.dato.responses.getPopularMovies.GetPopularResponse
import com.instaleap.dato.responses.getPopularTvSeries.GetPopularTVResponse
import com.instaleap.dato.responses.movieDatailResponse.MovieDetailDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMovieApi {

    @GET("genre/movie/list")
    suspend fun getGenresMovieList(): Response<GenresMoviesResponse>

    @GET("genre/movie/list")
    suspend fun getGenresTvList(): Response<GenresTVResponse>

    @GET("movie/popular")
    suspend fun getPopularMovie(@Query("page") page: Int = 1): Response<GetPopularResponse>

    @GET("tv/popular")
    suspend fun getTVSeries(@Query("page") page: Int = 1): Response<GetPopularTVResponse>

    @GET("discover/movie")
    suspend fun getMoviesListByGenre(
        @Query("with_genres") genreId: Int,
        @Query("page") page: Int = 1,
    ): Response<DiscoverMovieResponse>

    @GET("discover/movie")
    suspend fun getMoviesListWitouthGenre(
        @Query("page") page: Int = 1,
    ): Response<DiscoverMovieResponse>


    @GET("discover/tv")
    suspend fun getTvListByGenre(
        @Query("with_genres") genreId: Int,
        @Query("page") page: Int = 1,
    ): Response<DiscoverTvResponse>

    @GET("discover/tv")
    suspend fun getTvListWithoutGenre(
        @Query("page") page: Int = 1,
    ): Response<DiscoverTvResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movie_id: Int,
    ): Response<MovieDetailDto>

}