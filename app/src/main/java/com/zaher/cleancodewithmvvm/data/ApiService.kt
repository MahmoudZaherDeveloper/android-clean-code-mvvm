package com.zaher.cleancodewithmvvm.data

import com.zaher.cleancodewithmvvm.data.dto.ItemDto
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getItems(): List<ItemDto>
}