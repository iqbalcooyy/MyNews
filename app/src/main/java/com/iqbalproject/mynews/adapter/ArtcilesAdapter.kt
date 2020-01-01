package com.iqbalproject.mynews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iqbalproject.mynews.R
import com.iqbalproject.mynews.adapter.viewHolder.ArticleHolder
import com.iqbalproject.mynews.model.ArticleDetail

class ArtcilesAdapter(private val data: List<ArticleDetail>): RecyclerView.Adapter<ArticleHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        return ArticleHolder(parent.context, LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        return holder.bindItem(data.get(position))
    }
}