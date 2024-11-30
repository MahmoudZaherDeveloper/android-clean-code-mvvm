package com.zaher.cleancodewithmvvm.domain.usecases

import com.zaher.cleancodewithmvvm.domain.model.Item
import com.zaher.cleancodewithmvvm.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    operator fun invoke(): Flow<List<Item>> {
        return repository.getItems()
    }
}