package com.iqbalproject.mynews.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iqbalproject.mynews.model.Articles
import com.iqbalproject.mynews.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesViewModel : ViewModel() {

    private var status = MutableLiveData<Boolean>()
    private var data = MutableLiveData<Articles>()

    fun loadData(sourceId: String) {
        status.value = true

        NetworkConfig().api().newsArticle(sourceId = sourceId).enqueue(object : Callback<Articles> {
            override fun onFailure(call: Call<Articles>, t: Throwable) {
                status.value = false
                data.value = null
            }

            override fun onResponse(call: Call<Articles>, response: Response<Articles>) {
                status.value = true

                if (response.isSuccessful == false || response.body()?.articles.isNullOrEmpty()) {
                    status.value = false
                } else {
                    data.value = response.body()
                }
            }

        })
    }

    fun getData(): MutableLiveData<Articles> {
        return data
    }

    fun getStatus(): MutableLiveData<Boolean> {
        return status
    }
}