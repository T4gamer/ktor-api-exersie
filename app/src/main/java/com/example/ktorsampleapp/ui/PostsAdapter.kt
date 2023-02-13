package com.example.ktorsampleapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ktorexamplelab.model.posts_feed.PostFeedItem
import com.example.ktorsampleapp.databinding.PostItemBinding

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 07,Feb,2023
 */
class PostsAdapter() : ListAdapter<PostFeedItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PostFeedItem>() {

            override fun areItemsTheSame(oldItem: PostFeedItem, newItem: PostFeedItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: PostFeedItem, newItem: PostFeedItem): Boolean {
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

        fun bind(item: PostFeedItem) {
            Log.d("adapter", "bind $adapterPosition")
            itemBinding.apply {
                tvTitle.text = item.title
                tvContent.text = item.content
                ivPicture.load(item.picture)
            }
        }

    }
}