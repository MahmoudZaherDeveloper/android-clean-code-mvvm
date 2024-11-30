package com.zaher.cleancodewithmvvm.data.repository

import com.zaher.cleancodewithmvvm.data.ApiService
import com.zaher.cleancodewithmvvm.data.dto.ItemDto
import com.zaher.cleancodewithmvvm.domain.model.Item
import com.zaher.cleancodewithmvvm.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ItemRepository {
    override fun getItems(): Flow<List<Item>> = flow {
        val itemDtos = apiService.getItems()
        val items = itemDtos.map { it.toDomain() }
        emit(items)
    }.catch { emit(emptyList()) }

    private fun ItemDto.toDomain(): Item {
        return Item(userId = userId, id = id, title = title, body = body)
    }
}