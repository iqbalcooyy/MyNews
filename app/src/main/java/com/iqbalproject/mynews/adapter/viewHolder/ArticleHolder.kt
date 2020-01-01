package com.iqbalproject.mynews.adapter.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.iqbalproject.mynews.model.ArticleDetail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_item.view.*

class ArticleHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(article: ArticleDetail){
        Picasso.get().load(article.urlToImage).into(itemView.imgArticle)
        itemView.tvArticleName.text = article.title
        itemView.tvArticleDesc.text = article.description
    }
}