package com.iqbalproject.mynews.adapter.viewHolder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.iqbalproject.mynews.model.ArticleDetail
import com.iqbalproject.mynews.ui.ArticleDetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class ArticleHolder(private val context: Context, view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(article: ArticleDetail){
        Picasso.get().load(article.urlToImage).into(itemView.imgArticle)
        itemView.tvArticleName.text = article.title
        itemView.tvArticleDesc.text = article.description

        itemView.onClick {
            context.startActivity<ArticleDetailActivity>("detailUrl" to article.url)
        }
    }
}