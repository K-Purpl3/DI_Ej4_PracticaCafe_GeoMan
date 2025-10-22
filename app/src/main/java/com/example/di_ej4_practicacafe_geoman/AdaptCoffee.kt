package com.example.di_ej4_practicacafe_geoman

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptCoffee(
    private val coffeeList: MutableList<CoffeeShop>
) : RecyclerView.Adapter<AdaptCoffee.CoffeeViewHolder>() {

    inner class CoffeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewCoffee: ImageView = itemView.findViewById(R.id.imageViewCoffee)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)

        val textViewSubtit: TextView = itemView.findViewById(R.id.textViewSubtit)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBarCoffee)
        val textViewRating: TextView = itemView.findViewById(R.id.textViewRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coffee, parent, false)
        return CoffeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        val item = coffeeList[position]

        holder.imageViewCoffee.setImageResource(item.imageResId)
        holder.textViewName.text = item.name
        holder.textViewSubtit.text = item.subtit
        holder.ratingBar.rating = item.rating
        holder.textViewRating.text = "Puntuación: %.1f".format(item.rating)

        holder.ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            item.rating = rating
            holder.textViewRating.text = "Puntuación: %.1f".format(rating)
        }
    }

    override fun getItemCount(): Int = coffeeList.size
}
