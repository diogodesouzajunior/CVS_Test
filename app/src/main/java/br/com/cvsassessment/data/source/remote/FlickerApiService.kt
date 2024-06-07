package br.com.cvsassessment.data.source.remote

import br.com.cvsassessment.data.model.FlickerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickerApiService {
    @GET("services/feeds/photos_public.gne?format=json&nojsoncallback=1")
    suspend fun searchImages(@Query("tags") tags: String): FlickerResponse
}

