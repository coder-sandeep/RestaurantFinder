package com.codersandeep.restaurantfinder.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codersandeep.restaurantfinder.models.Restaurant
import com.codersandeep.restaurantfinder.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val restaurantRepository: RestaurantRepository) : ViewModel() {

    val restaurantLiveData : LiveData<Restaurant>
        get() = restaurantRepository.prestaurantLiveData

    fun getAllRestaurant() {
        viewModelScope.launch {
            restaurantRepository.getAllRestaurant()
        }
    }
}