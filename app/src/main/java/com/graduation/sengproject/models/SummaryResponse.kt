package com.graduation.sengproject.models

data class SummaryResponse(
    val Countries: List<Country>,
    val Date: String,
    val Global: Global,
    val ID: String,
    val Message: String
)