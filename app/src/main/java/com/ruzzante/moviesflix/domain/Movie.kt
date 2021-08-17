package com.ruzzante.moviesflix.domain

class Movie(
    val id:Int,
    val titulo:String,
    val descricao:String,
    val imagem:String?,
    val data_lancamento:String?
) {
}