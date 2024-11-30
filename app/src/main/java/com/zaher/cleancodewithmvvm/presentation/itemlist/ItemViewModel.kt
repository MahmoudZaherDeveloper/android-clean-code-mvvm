package com.zaher.cleancodewithmvvm.presentation.itemlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaher.cleancodewithmvvm.domain.model.Item
import com.zaher.cleancodewithmvvm.domain.usecases.GetItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase
) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items.asStateFlow()

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            getItemsUseCase().collect { itemList ->
                _items.value = itemList
            }
        }
    }
}
