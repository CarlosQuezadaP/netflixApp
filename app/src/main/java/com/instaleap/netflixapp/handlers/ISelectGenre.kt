package com.instaleap.netflixapp.handlers

import com.instaleap.domain.models.GenreItemDomain

interface ISelectGenre {
    fun selectGenre(genreItemDomain: GenreItemDomain)
}
