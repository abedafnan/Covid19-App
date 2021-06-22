package com.graduation.sengproject.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graduation.sengproject.models.CountriesResponse
import com.graduation.sengproject.models.CountryDetailsResponse
import com.graduation.sengproject.models.SummaryResponse
import com.graduation.sengproject.networking.RetrofitClient
import com.graduation.sengproject.networking.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardViewModel : ViewModel() {

    private val _summary = MutableLiveData<SummaryResponse>()
    private val _countries = MutableLiveData<CountriesResponse>()
    private val _countryDetails = MutableLiveData<CountryDetailsResponse>()

    val summary: LiveData<SummaryResponse>
        get() = _summary
    val countries: LiveData<CountriesResponse>
        get() = _countries
    val countryDetails: LiveData<CountryDetailsResponse>
        get() = _countryDetails

    init {
        getSummary()
    }

    private fun getSummary(){
        val service = RetrofitClient.getRetrofit().create(RetrofitService::class.java)
        service.summary.enqueue(object :
            Callback<SummaryResponse> {
            override fun onResponse(call: Call<SummaryResponse>, response: Response<SummaryResponse>) {
                if (response.isSuccessful) {
                    _summary.value = response.body()
                }
            }

            override fun onFailure(call: Call<SummaryResponse>, t: Throwable) {
                println("Error ${t.message}")
            }
        })
    }

    fun getCountries(){
        val service = RetrofitClient.getRetrofit().create(RetrofitService::class.java)
        service.countries.enqueue(object :
            Callback<CountriesResponse> {
            override fun onResponse(call: Call<CountriesResponse>, response: Response<CountriesResponse>) {
                if (response.isSuccessful) {
                    _countries.value = response.body()
                }
            }

            override fun onFailure(call: Call<CountriesResponse>, t: Throwable) {
                println("Error ${t.message}")
            }
        })
    }

    fun getCountryDetails(country: String) {
        val url = "country/$country"

        val service = RetrofitClient.getRetrofit().create(RetrofitService::class.java)
        service.getCountryDetails(url).enqueue(object :
            Callback<CountryDetailsResponse> {
            override fun onResponse(call: Call<CountryDetailsResponse>, response: Response<CountryDetailsResponse>) {
                if (response.isSuccessful) {
                    _countryDetails.value = response.body()
                }
            }

            override fun onFailure(call: Call<CountryDetailsResponse>, t: Throwable) {
                println("Error ${t.message}")
            }
        })
    }
}