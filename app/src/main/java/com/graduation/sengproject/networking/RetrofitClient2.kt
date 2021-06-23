package com.graduation.sengproject.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient2 {
    companion object{
        fun getRetrofit() : Retrofit {

            val baseUrl = "https://coronavirus-smartable.p.rapidapi.com/"

            val httpOk = OkHttpClient.Builder()

            httpOk.addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("x-rapidapi-key", "a8e5eae2b0msh5e5555c9695bf50p1ac57ejsn67cabf911fa6")
                    .addHeader("x-rapidapi-host", "coronavirus-smartable.p.rapidapi.com")
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