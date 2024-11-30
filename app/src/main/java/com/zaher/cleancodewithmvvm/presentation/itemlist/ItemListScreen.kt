package com.zaher.cleancodewithmvvm.presentation.itemlist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zaher.cleancodewithmvvm.domain.model.Item

@Composable
fun ItemListScreen(viewModel: ItemViewModel = hiltViewModel()) {
    val items by viewModel.items.collectAsState()
    CardItems(items)
}

@Composable
fun CardItems(items: List<Item>) {
    LazyColumn(
        // to make the list items above the below bar and under the top action bar
        contentPadding = PaddingValues(
            top = WindowInsets.systemBars.asPaddingValues().calculateTopPadding(),
            bottom = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding()
        )
    ) {
        // this key is used to prevent recomposition of items
        items(items, key = { it.id }) { item ->
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Text(text = item.title, modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemsPreview() {
    val previewItems = listOf(
        Item(1, 1, "First title", "First body"),
        Item(2, 2, "Second title", "Second body"),
        Item(3, 3, "Third title", "Third body")
    )
    CardItems(items = previewItems)
}
