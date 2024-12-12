package com.qdn.cvsdemo.data.repository

import com.qdn.cvsdemo.data.api.FlickrApi
import com.qdn.cvsdemo.data.model.FlickrImage
import com.qdn.cvsdemo.data.model.toDomainModel
import javax.inject.Inject

class FlickrRepository @Inject constructor(
    private val api: FlickrApi
) {
    suspend fun searchImages(tags: String): Result<List<FlickrImage>> {
        return try {
            val response = api.searchImages(tags)
            Result.success(response.items.map { it.toDomainModel()})
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}