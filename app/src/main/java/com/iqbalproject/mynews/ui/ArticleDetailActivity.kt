package com.iqbalproject.mynews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iqbalproject.mynews.R
import kotlinx.android.synthetic.main.activity_article_detail.*

class ArticleDetailActivity : AppCompatActivity() {

    private lateinit var detailUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        detailUrl = intent.getStringExtra("detailUrl")

        wvArticleDetail.loadUrl(detailUrl)
    }
}
