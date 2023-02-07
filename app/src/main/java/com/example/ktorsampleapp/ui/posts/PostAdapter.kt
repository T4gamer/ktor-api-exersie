package com.example.ktorsampleapp.ui.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ktorsampleapp.databinding.PostItemBinding
import com.example.ktorsampleapp.model.remote.Post

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 07,Feb,2023
 */
class PostAdapter : ListAdapter<Post, RecyclerView.ViewHolder>(DIFF_CALLBACK){
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Post>() {

            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.title == newItem.title || oldItem.content == newItem.content ||
                        oldItem.picture == newItem.picture
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val  binding: PostItemBinding =
            PostItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }


    inner class ViewHolder(val itemBinding: PostItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Post){
            itemBinding.apply {
                tvTitle.text = item.title
                tvContent.text = item.content
                ivPicture.load(item.picture)
            }
        }
    }
}