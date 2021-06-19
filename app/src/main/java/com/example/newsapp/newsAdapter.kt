package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class newsAdapter(private val items: ArrayList<String>,private val listner :newsitemclick): RecyclerView.Adapter<newsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newsViewHolder {
        //layout inflator conver xlm into view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        val viewholder = newsViewHolder(view)
        view.setOnClickListener{
            listner.onItemClicked(items[viewholder.adapterPosition])
        }
        return viewholder

    }

    override fun onBindViewHolder(holder: newsViewHolder, position: Int) {
        //binding item with data
        val currentItem = items[position]
        holder.tileview.text=currentItem
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
class newsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tileview= itemView.findViewById<TextView>(R.id.title)

}
interface newsitemclick{
    fun onItemClicked(item:String)
}