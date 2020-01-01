package com.iqbalproject.mynews.adapter.viewHolder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.iqbalproject.mynews.model.SourceDetail
import com.iqbalproject.mynews.ui.ArticlesActivity
import kotlinx.android.synthetic.main.source_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class SourceHolder(private val context: Context, view: View) : RecyclerView.ViewHolder(view) {
    fun bindView(source: SourceDetail) {
        itemView.tvSourceName.text = source.name
        itemView.tvDescSource.text = source.description

        itemView.onClick {
            context.startActivity<ArticlesActivity>("sourceId" to source.id)
        }
    }
}