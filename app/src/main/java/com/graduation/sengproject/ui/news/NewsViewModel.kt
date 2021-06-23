package com.graduation.sengproject.ui.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.sengproject.models.NewsResponse
import com.graduation.sengproject.networking.RetrofitClient
import com.graduation.sengproject.networking.RetrofitClient2
import com.graduation.sengproject.networking.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    private val _news = MutableLiveData<NewsResponse>()

    val news: LiveData<NewsResponse>
        get() = _news

    init {
        getSummary()
    }

    private fun getSummary(){
        val service = RetrofitClient2.getRetrofit().create(RetrofitService::class.java)
        service.covidNews.enqueue(object :
            Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    _news.value = response.body()
                }

                Log.d("response", "Response: $response")
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("response", "Error ${t.message}")
            }
        })
    }
}