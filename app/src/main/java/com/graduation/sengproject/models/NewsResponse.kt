package com.graduation.sengproject.models

data class NewsResponse(
    val location: Location,
    val news: List<New>,
    val updatedDateTime: String
)