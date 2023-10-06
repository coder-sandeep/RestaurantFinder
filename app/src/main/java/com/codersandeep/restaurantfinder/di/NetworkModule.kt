package com.codersandeep.restaurantfinder.di


import com.codersandeep.restaurantfinder.api.RestaurantAPI
import com.codersandeep.restaurantfinder.models.Restaurant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://codejudge-question-artifacts.s3.ap-south-1.amazonaws.com").build()
    }
    @Singleton
    @Provides
    fun providesRestaurantAPI(retrofit: Retrofit) : RestaurantAPI{
        return retrofit.create(RestaurantAPI::class.java)
    }
}