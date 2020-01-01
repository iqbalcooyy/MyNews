package com.iqbalproject.mynews.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.iqbalproject.mynews.R
import com.iqbalproject.mynews.adapter.ArtcilesAdapter
import com.iqbalproject.mynews.model.ArticleDetail
import kotlinx.android.synthetic.main.activity_articles.*

class ArticlesActivity : AppCompatActivity() {

    private lateinit var viewModel: ArticlesViewModel
    private lateinit var sourceId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        sourceId = intent.getStringExtra("sourceId")

        viewModel = ViewModelProviders.of(this).get(ArticlesViewModel::class.java)

        viewModel.loadData(sourceId)

        viewModel.getStatus().observe(this, Observer {
            if (it == false){
                rvArticles.visibility = View.GONE
                tvArticleStat.visibility = View.VISIBLE
            } else{
                rvArticles.visibility = View.VISIBLE
                tvArticleStat.visibility = View.GONE
            }
        })

        viewModel.getData().observe(this, Observer {
            it?.articles?.let {
                showData(it)
            }
        })
    }

    private fun showData(data: List<ArticleDetail>) {
        rvArticles.adapter = ArtcilesAdapter(data)
    }
}
