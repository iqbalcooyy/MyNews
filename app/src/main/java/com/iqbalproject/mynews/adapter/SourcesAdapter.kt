package com.iqbalproject.mynews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iqbalproject.mynews.R
import com.iqbalproject.mynews.adapter.viewHolder.SourceHolder
import com.iqbalproject.mynews.model.SourceDetail

class SourcesAdapter(private val data: List<SourceDetail>): RecyclerView.Adapter<SourceHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceHolder {
        return SourceHolder(parent.context, LayoutInflater.from(parent.context).inflate(R.layout.source_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: SourceHolder, position: Int) {
        holder.bindView(data.get(position))
    }
}