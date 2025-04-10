package com.searchchallenge.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.searchchallenge.ui.composable.parameterprovider.productListNamesParameterProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onSearch: (String) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    var query by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            SearchBar(
                inputField = {
                    SearchBarDefaults.InputField(
                        query = query,
                        onQueryChange = {
                            query = it
                        },
                        onSearch = {
                            onSearch(query)
                        },
                        expanded = true,
                        onExpandedChange = { /*active = it*/ },
                        placeholder = { Text("Search...") },
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = "Search"
                            )
                        },
                    )
                },
                expanded = false, //active,
                onExpandedChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(20.dp),
            ) {}
        },
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.LightGray,
        contentColor = Color.LightGray,
        content = { paddingValues ->
            content(paddingValues)
        },
    )
}

@Composable
@Preview(showBackground = true)
private fun SearchScreenPreview() {
    SearchScreen(
        onSearch = { "Search result for: ${productListNamesParameterProvider.first()}" },
        content = {
            Column() {
                Text("Search Results:")
            }
        }
    )
}

