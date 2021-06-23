package com.graduation.sengproject.ui.news

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.graduation.sengproject.R
import com.graduation.sengproject.databinding.ItemNewsBinding
import com.graduation.sengproject.models.New
import com.squareup.picasso.Picasso


class NewsAdapter(var data: List<New>, val callback: CustomOnItemClickListener)
    : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(var itemNewsBinding: ItemNewsBinding) :
        RecyclerView.ViewHolder(itemNewsBinding.root) {
        fun bind(new: New) {
            itemNewsBinding.tvTitle.text = new.title
            itemNewsBinding.tvExcerpt.text = new.excerpt

            if (!new.images.isNullOrEmpty()) {
                Picasso.get().load(new.images[0].url)
                    .into(itemNewsBinding.ivImage)
            } else {
                itemNewsBinding.ivImage.setImageResource(R.drawable.placeholder)
            }

            itemNewsBinding.root.setOnClickListener {
                callback.onItemClick(new.webUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val round = data[position]

        holder.bind(round)
    }

    override fun getItemCount() = data.size

    interface CustomOnItemClickListener {
        fun onItemClick(url: String)
    }
}