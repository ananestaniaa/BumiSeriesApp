package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NovelAdapter (private val context: Context, private val novel: List<NovelClass>, val listener: (NovelClass) -> Unit)
    : RecyclerView.Adapter<NovelAdapter.NovelViewHolder>(){
    class NovelViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val novelimg = view.findViewById<ImageView>(R.id.image)
        val novelname = view.findViewById<TextView>(R.id.tv_name)
        val noveldate = view.findViewById<TextView>(R.id.tv_date)
        val novelauthor = view.findViewById<TextView>(R.id.tv_author)

        fun bindView(novel: NovelClass, listener: (NovelClass) -> Unit){
            novelimg.setImageResource(novel.novelimg)
            novelname.text = novel.novelname
            noveldate.text = novel.noveldate
            novelauthor.text = novel.novelauthor
            itemView.setOnClickListener{
                (listener(novel))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovelViewHolder {
        return NovelViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NovelViewHolder, position: Int) {
        holder.bindView(novel[position], listener)
    }

    override fun getItemCount(): Int = novel.size

}