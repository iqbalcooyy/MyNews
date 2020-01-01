package com.iqbalproject.mynews

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.iqbalproject.mynews.ui.SourcesActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var category: MutableList<String> = mutableListOf()
    private lateinit var gridAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //supportFragmentManager.beginTransaction().replace(R.id.container, Movie()).commit()

        initData()

        gridAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, category)
        gvCategory.adapter = gridAdapter

        gvCategory.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == 0){
                    startActivity<SourcesActivity>("category" to "")
                }else{
                    startActivity<SourcesActivity>("category" to parent?.getItemAtPosition(position).toString())
                }
            }
        }
    }

    private fun initData() {
        val cat = resources.getStringArray(R.array.categories)

        category.clear()

        for (i in cat.indices){
            category.add(i, cat[i])
        }
    }
}
