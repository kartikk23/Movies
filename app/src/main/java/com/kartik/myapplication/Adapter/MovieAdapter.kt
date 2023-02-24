package com.kartik.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kartik.myapplication.R
import com.kartik.myapplication.Room.MovieEntity
import com.kartik.myapplication.Room.MovieRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieAdapter(
    private val movieRepository: MovieRepository
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movieList: List<MovieEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        val viewHolder = MovieViewHolder(view)
        GlobalScope.launch {
            movieList = movieRepository.getAllMovies()
            notifyDataSetChanged()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.TitleTv.text = movie.Title
        holder.yearTv.text = movie.Year
        holder.runtimeTv.text =movie.Runtime
        holder.castTv.text = movie.Cast
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val TitleTv = view.findViewById<TextView>(R.id.title)
        val yearTv = view.findViewById<TextView>(R.id.year)
        val runtimeTv = view.findViewById<TextView>(R.id.runtime)
        val castTv = view.findViewById<TextView>(R.id.cast)

    }
}