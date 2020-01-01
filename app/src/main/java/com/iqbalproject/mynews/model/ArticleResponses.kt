package com.iqbalproject.mynews.model

data class Articles(
    val articles: List<ArticleDetail>? = null
)

data class ArticleDetail(
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null
)