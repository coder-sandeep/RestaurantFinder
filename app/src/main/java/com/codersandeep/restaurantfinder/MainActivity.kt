package com.codersandeep.restaurantfinder

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codersandeep.restaurantfinder.models.Restaurant
import com.codersandeep.restaurantfinder.models.Result
import com.codersandeep.restaurantfinder.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var rvDataAll: MutableList<Result>
    private lateinit var rvData: MutableList<Result>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_main)
        val searchView = findViewById<SearchView>(R.id.search_main)
        mainViewModel.getAllRestaurant()
        mainViewModel.restaurantLiveData.observe(this){
            Log.d("TAGG","success")
            rvDataAll = it.results.toMutableList()
            rvData = it.results.toMutableList()
            recyclerView.adapter = ReAdapter(rvData)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                rvData.clear()
                if(newText.isNotEmpty()){
                    rvData.addAll(rvDataAll.filter { element ->
                        element.name.lowercase().contains(newText.lowercase())
                    }.toMutableList())
                }
                else{
                    rvData.clear()
                    rvData.addAll(rvDataAll)
                }
                recyclerView.adapter?.notifyDataSetChanged()
                return false
            }
        })
    }
}