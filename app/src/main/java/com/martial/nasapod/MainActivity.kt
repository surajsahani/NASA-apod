package com.martial.nasapod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val data : ArrayList<Int>
        for (data in 0..5) {

        }


        initialize()
        recyclerView.adapter = MainAdapter(this, data)
    }
    fun initialize() {
        recyclerView = findViewById(R.id.rlView)
    }
}