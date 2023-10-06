package com.codersandeep.restaurantfinder.models

data class Restaurant(
    val html_attributions: List<Any>,
    val next_page_token: String,
    val results: List<Result>
)