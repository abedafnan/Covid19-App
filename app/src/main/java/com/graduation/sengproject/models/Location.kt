package com.graduation.sengproject.models

data class Location(
    val countryOrRegion: String,
    val county: Any,
    val isoCode: String,
    val lat: Double,
    val long: Double,
    val provinceOrState: Any
)