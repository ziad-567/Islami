package com.example.islami.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterTitleBinding

class ChapterRecyclerAdapter(private val chapterList: List<String>):
    RecyclerView.Adapter<ChapterRecyclerAdapter.ViewHolder>() {

    class ViewHolder ( private val itemBinding :ItemChapterTitleBinding):RecyclerView.ViewHolder
        (itemBinding.root) {
        fun bind(title:String) {
            itemBinding.title.text=title
        }
    }
   var onItemClickListener : OnItemClickListener? = null
    fun interface OnItemClickListener{
        fun onItemClick(item : String, position: Int)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding : ItemChapterTitleBinding=
            ItemChapterTitleBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int =chapterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = chapterList[position]
        holder.bind (title)

        onItemClickListener?.let {listener->
            holder.itemView.setOnClickListener{
                listener.onItemClick(title,position)
            }
        }


    }
}