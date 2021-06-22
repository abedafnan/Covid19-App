package com.graduation.sengproject.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        fun getRetrofit() : Retrofit {

            val baseUrl = "https://api.covid19api.com/"

            val httpOk = OkHttpClient.Builder()

            httpOk.addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Basic Y29yb25hOlpVYXY0dmF3ekNmTWNNWEhWOEI=")
                    .build()

                chain.proceed(request)
            }

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpOk.build())
                .build()
        }
    }
}