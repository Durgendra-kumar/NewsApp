package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), newsitemclick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //calling recyclerview
        recyclerView()
    }
    fun recyclerView(){
        val recyclerview  = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val item = fetchdata()
        val adapter: newsAdapter = newsAdapter(item,this)
        recyclerview.adapter = adapter


    }
    private fun fetchdata():ArrayList<String>{
        val list = ArrayList<String>()
        for(i in 0 until 100){
            list.add("item $i")
        }
        return list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this, "clicked item is $item", Toast.LENGTH_SHORT).show()
    }
}