package com.codersandeep.restaurantfinder.api

    import com.codersandeep.restaurantfinder.models.Restaurant
    import retrofit2.Response
    import retrofit2.http.GET

    interface RestaurantAPI {
        @GET("/q-1731/final.json")
        suspend fun getAllRestaurant() : Response<Restaurant>
    }