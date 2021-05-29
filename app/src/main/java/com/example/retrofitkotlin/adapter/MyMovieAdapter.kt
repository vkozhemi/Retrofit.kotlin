package com.example.retrofitkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkotlin.model.Movie
import com.example.retrofitkotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*


class MyMovieAdapter(private val context: Context, private val movieList: MutableList<Movie>)
    : RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.image_movie
        val txt_name: TextView = itemView.txt_name
        val txt_team: TextView = itemView.txt_team
        val txt_createdby: TextView = itemView.txt_createdby

        fun bind(listItem: Movie) {
            image.setOnClickListener {
                Toast.makeText(it.context, "Clicked on ${itemView.image_movie}", Toast.LENGTH_LONG)
            }
            txt_name.setOnClickListener {
                Toast.makeText(it.context, "Clicked on ${itemView.txt_name}", Toast.LENGTH_LONG)
            }
            txt_team.setOnClickListener {
                Toast.makeText(it.context, "Clicked on ${itemView.txt_team}", Toast.LENGTH_LONG)
            }
            txt_createdby.setOnClickListener {
                Toast.makeText(it.context, "Clicked on ${itemView.txt_createdby}", Toast.LENGTH_LONG)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMovieAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyMovieAdapter.MyViewHolder, position: Int) {
        var listItem: Movie = movieList[position]
        holder.bind(listItem)
        Picasso.get().load(movieList[position].imageurl).into(holder.image)

        holder.txt_name.text = movieList[position].name
        holder.txt_team.text = movieList[position].team
        holder.txt_createdby.text = movieList[position].createdby
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}