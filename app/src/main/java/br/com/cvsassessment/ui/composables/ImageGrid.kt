package br.com.cvsassessment.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.cvsassessment.data.model.FlickerItem

@Composable
fun ImageGrid(images: List<FlickerItem>, onImageClick: (FlickerItem) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(images) { image ->
            ImageThumbnail(image = image, onClick = { onImageClick(image) })
        }
    }
}
