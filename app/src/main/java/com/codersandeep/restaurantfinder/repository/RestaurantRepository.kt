package com.codersandeep.restaurantfinder.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.codersandeep.restaurantfinder.api.RestaurantAPI
import com.codersandeep.restaurantfinder.models.Restaurant
import javax.inject.Inject

class RestaurantRepository @Inject constructor(private val restaurantAPI: RestaurantAPI){
//    private val _productsLiveData = MutableLiveData<NetworkResponse<List<ProductsItem>>>()
//    private val _singleProductLiveData = MutableLiveData<NetworkResponse<ProductsItem>>()

    private val _restaurantLiveData = MutableLiveData<Restaurant>()
    val prestaurantLiveData get() = _restaurantLiveData
    suspend fun getAllRestaurant(){

        val result = restaurantAPI.getAllRestaurant()
        if(result.isSuccessful && result.body() != null) {
           _restaurantLiveData.postValue(result.body())
        }
        else
            Log.d("TAGG", "something went wrong")
    }
}