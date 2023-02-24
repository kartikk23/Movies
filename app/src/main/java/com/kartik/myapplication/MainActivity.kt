package com.kartik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.kartik.myapplication.Adapter.MovieAdapter
import com.kartik.myapplication.Room.AppDatabase

class MainActivity : AppCompatActivity() {

    lateinit var refresh: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "my_database"
        ).build()

        val dao = db.movieDao()
        val data = dao.getAll()

        val recyclerView = findViewById<RecyclerView>(R.id.movieRecView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieAdapter(data)

        refresh.setOnClickListener{
            Toast.makeText(this@MainActivity, "Refreshing", Toast.LENGTH_LONG)
        }
    }


}