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

class MovieAdapter(private var isFirst:Boolean=true):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var liveData:List<Result?>?=null

    fun setList(liveData: List<Result?>?){
        this.liveData=liveData
        notifyDataSetChanged()
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val posterView: ImageView = view.findViewById(R.id.image2)
        val txtBaslik: TextView = view.findViewById(R.id.txttittle2)
        val txtGenre: TextView = view.findViewById(R.id.txtGenre2)

        fun bind(data: Result) {
            txtBaslik.text=data.title
            txtGenre.text=data.genreİds.toString()

            Glide.with(posterView).load("https://www.themoviedb.org/t/p/w1280/"+data.posterPath).into(posterView)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.popular_layout_item,parent,false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
       if (liveData==null){
           return 0
       }else if(isFirst){
           return 4
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