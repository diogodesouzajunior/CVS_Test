package br.com.cvsassessment.service

import br.com.cvsassessment.data.model.FlickerResponse
import br.com.cvsassessment.data.source.remote.FlickerApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class FlickerRepository(private val apiService: FlickerApiService) {

    suspend fun searchImages(query: String): FlickerResponse? {
        return withContext(Dispatchers.IO) {
            try {
                apiService.searchImages(query)
            } catch (e: HttpException) {
                // Handle HTTP exceptions
                null
            } catch (e: Exception) {
                // Handle other exceptions
                null
            }
        }
    }
}
