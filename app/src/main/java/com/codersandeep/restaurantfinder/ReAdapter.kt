package com.codersandeep.restaurantfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codersandeep.restaurantfinder.models.Restaurant
import com.codersandeep.restaurantfinder.models.Result
import com.squareup.picasso.Picasso

class ReAdapter(private val result: List<Result>) : RecyclerView.Adapter<ReAdapter.ReViewHolder>() {

    inner class ReViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.item_image)
        val name = itemView.findViewById<TextView>(R.id.item_name)
        val vicinity = itemView.findViewById<TextView>(R.id.item_vicinity)
        val rating = itemView.findViewById<TextView>(R.id.item_rating)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return ReViewHolder(view)
    }

    override fun getItemCount(): Int {
        return result.size;
    }

    override fun onBindViewHolder(holder: ReViewHolder, position: Int) {
        holder.name.text = result[position].name
        holder.vicinity.text = result[position].vicinity
        holder.rating.text = "${result[position].rating} ⭐"

        Picasso.get()
            .load(result[position].photos[0].imgUrl)
            .into(holder.image)
    }
}