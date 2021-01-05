package com.instaleap.netflixapp

import com.instaleap.domain.models.GenreItemDomain

interface ISelectGenre {
    fun selectGenre(genreItemDomain: GenreItemDomain)
}
