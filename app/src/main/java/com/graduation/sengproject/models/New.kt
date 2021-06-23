package com.graduation.sengproject.models

data class New(
    val excerpt: String,
    val images: List<Image>,
    val originalUrl: String,
    val path: String,
    val sourceUrl: Any,
    val title: String,
    val webUrl: String
)