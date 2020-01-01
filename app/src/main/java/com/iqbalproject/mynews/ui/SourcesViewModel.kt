package com.iqbalproject.mynews.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iqbalproject.mynews.model.Sources
import com.iqbalproject.mynews.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SourcesViewModel : ViewModel() {

    private var status = MutableLiveData<Boolean>()
    private var data = MutableLiveData<Sources>()

    /*init {
        loadData("")
    }*/

    fun loadData(cat: String) {
        status.value = true

        NetworkConfig().api().newsSource(category = cat).enqueue(object : Callback<Sources>{
            override fun onFailure(call: Call<Sources>, t: Throwable) {
                status.value = false
                data.value = null
            }

            override fun onResponse(call: Call<Sources>, response: Response<Sources>) {
                status.value = true

                if (response.isSuccessful == false || response.body()?.sources.isNullOrEmpty()){
                    status.value = false
                }else{
                    data.value = response.body()
                }
            }
        })
    }

    fun getData(): MutableLiveData<Sources>{
        return data
    }

    fun getStatus(): MutableLiveData<Boolean>{
        return status
    }
}
