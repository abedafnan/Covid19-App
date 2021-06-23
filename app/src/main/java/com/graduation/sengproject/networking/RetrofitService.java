package com.graduation.sengproject.networking;

import com.graduation.sengproject.models.CountriesResponse;
import com.graduation.sengproject.models.CountryDetailsResponse;
import com.graduation.sengproject.models.NewsResponse;
import com.graduation.sengproject.models.SummaryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RetrofitService {

    @GET("summary")
    Call<SummaryResponse> getSummary();

    @GET("countries")
    Call<CountriesResponse> getCountries();

    @GET
    Call<CountryDetailsResponse> getCountryDetails(@Url String url);

    @GET("news/v1/US/")
    Call<NewsResponse> getCovidNews();
}