package com.zaher.cleancodewithmvvm.domain.repository

import com.zaher.cleancodewithmvvm.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItems(): Flow<List<Item>>
}
