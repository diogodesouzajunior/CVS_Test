package br.com.cvsassessment.di

import br.com.cvsassessment.data.source.remote.FlickerApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val BASE_URL = "https://api.flickr.com/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val flickerApiService: FlickerApiService = retrofit.create(FlickerApiService::class.java)
}
