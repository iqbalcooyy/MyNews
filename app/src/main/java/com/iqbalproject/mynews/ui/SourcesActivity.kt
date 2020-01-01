package com.iqbalproject.mynews.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.iqbalproject.mynews.R
import com.iqbalproject.mynews.adapter.SourcesAdapter
import com.iqbalproject.mynews.model.SourceDetail
import kotlinx.android.synthetic.main.activity_sources.*

class SourcesActivity : AppCompatActivity() {

    private lateinit var viewModel: SourcesViewModel
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sources)

        category = intent.getStringExtra("category")

        viewModel = ViewModelProviders.of(this).get(SourcesViewModel::class.java)

        viewModel.loadData(category)

        viewModel.getStatus().observe(this, Observer {
            if (it == false){
                rvSources.visibility = View.GONE
                tvSourceStat.visibility = View.VISIBLE
            }else{
                rvSources.visibility = View.VISIBLE
                tvSourceStat.visibility = View.GONE
            }
        })

        viewModel.getData().observe(this, Observer {
            it?.sources?.let {
                showData(it)
            }
        })
    }

    private fun showData(data: List<SourceDetail>) {
        rvSources.adapter = SourcesAdapter(data)
    }
}
