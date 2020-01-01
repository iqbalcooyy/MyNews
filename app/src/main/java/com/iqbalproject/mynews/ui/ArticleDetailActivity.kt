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

        setupWebView()
        wvArticleDetail.loadUrl(detailUrl)
    }

    private fun setupWebView() {
        wvArticleDetail.setInitialScale(1)
        val webSetting = wvArticleDetail.settings
        webSetting.setAppCacheEnabled(false)
        webSetting.builtInZoomControls = true
        webSetting.displayZoomControls = false
        webSetting.javaScriptEnabled = true
        webSetting.useWideViewPort = true
        webSetting.domStorageEnabled = true
    }
}
