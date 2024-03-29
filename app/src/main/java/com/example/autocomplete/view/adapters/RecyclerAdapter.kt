package com.example.autocomplete.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.autocomplete.R

class RecyclerAdapter(private val data: ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityName.text = data[position]

    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val item = itemView.findViewById<CardView>(R.id.item)
        val cityName = itemView.findViewById<TextView>(R.id.cityName)
    }
}