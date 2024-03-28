package com.example.movie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.models.Result

class RecentMovieAdapter():RecyclerView.Adapter<RecentMovieAdapter.MovieViewHolder>() {

    var liveData:List<Result?>?=null

    fun setList(liveData: List<Result?>?){
        this.liveData=liveData
        notifyDataSetChanged()
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val posterView: ImageView = view.findViewById(R.id.posterView)
        val txtBaslik: TextView = view.findViewById(R.id.txtBaslik)
        val txtGenre: TextView = view.findViewById(R.id.txtGenre)
        val txtVoteAvegare:TextView=view.findViewById(R.id.txtVoteAverage)
        val txtReleaseDate:TextView=view.findViewById(R.id.txtReleaseDate)

        fun bind(data: Result) {
            txtBaslik.text=data.title
            txtGenre.text=data.genreİds.toString()
            txtReleaseDate.text=data.releaseDate
            txtVoteAvegare.text=data.voteAverage.toString()+"/10"

            Glide.with(posterView).load("https://www.themoviedb.org/t/p/w1280/"+data.posterPath).into(posterView)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recent_movie_item,parent,false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (liveData==null){
            return 0
        }else{
            return liveData!!.size
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        liveData?.get(position)?.let {
            holder.bind(it)
        }
    }

}