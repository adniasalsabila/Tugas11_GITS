package com.gits.authapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val data = arrayListOf<String>();

            data.add("Fast & Furious 9")
            data.add("A Quiet Place: Part II")
            data.add("The Conjuring: The Devil Made Me Do It")
            data.add("Peter Rabbit 2: The Runaway")
            data.add("Morbius")
            data.add("Black Widow")
            data.add("Run")
            data.add("The Seventh Day")
            data.add("Gretel and Hansel")
            data.add("Space Jam: A new Legacy")

        val adapter = ListAdapter(this, data)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}