package br.com.cvsassessment.ui.composables

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.cvsassessment.ui.viewmodel.ImageSearchViewModel

@Composable
fun SearchScreen(viewModel: ImageSearchViewModel = viewModel()) {
    val images by viewModel.images.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val selectedImage by viewModel.selectedImage.collectAsState()
    val searchBarText by viewModel.searchBarText.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AnimatedVisibility(
                visible = selectedImage != null
            ) {
                TopAppBar(
                    {

                    }, navigationIcon = {
                        selectedImage?.let {
                            IconButton(onClick = { viewModel.deselectImage() }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                            }
                        }
                    }
                )
            }
            AnimatedVisibility(
                visible = selectedImage == null
            ) {
                SearchBar(
                    text = searchBarText,
                    onTextChange = { viewModel.searchImages(it) }
                )
            }
            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                when {
                    selectedImage != null -> {
                        selectedImage?.let {
                            ImageDetailView(image = it)
                        }
                    }

                    searchBarText.isEmpty() -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Let's find some interesting images! Start your search by typing in the search bar above")
                        }
                    }

                    images.isEmpty() -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "No results found for your search")
                        }
                    }

                    else -> {
                        ImageGrid(images = images, onImageClick = { viewModel.selectImage(it) })
                    }
                }
            }
        }
        BackHandler(enabled = selectedImage != null) {
            viewModel.deselectImage()
        }
    }
}
