package com.qdn.cvsdemo.data.api

import com.qdn.cvsdemo.data.model.FlickrResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("photos_public.gne?format=json&nojsoncallback=1")
    suspend fun searchImages(@Query("tags") tags: String): FlickrResponse
}