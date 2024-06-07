package br.com.cvsassessment.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit
) {
    var searchQuery by remember { mutableStateOf(text) }

    OutlinedTextField(
        value = searchQuery,

        onValueChange = {
            searchQuery = it
            onTextChange(it)
        },
        modifier = Modifier
            .fillMaxWidth(),
        placeholder = { Text("Search", color = Color.White) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Blue,
            cursorColor = Color.Blue
        )
    )
}
