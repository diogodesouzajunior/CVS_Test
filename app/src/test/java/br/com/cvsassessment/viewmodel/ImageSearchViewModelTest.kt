package br.com.cvsassessment.viewmodel

import br.com.cvsassessment.data.model.FlickerItem
import br.com.cvsassessment.data.model.Media
import br.com.cvsassessment.ui.viewmodel.ImageSearchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ImageSearchViewModelTest {

    private lateinit var viewModel: ImageSearchViewModel

    @Before
    fun setup() {
        viewModel = ImageSearchViewModel()
    }

    @Test
    fun `selectImage should update selectedImage state flow`() {
        val image = FlickerItem("title", Media("media"), "description", "author", "published")

        viewModel.selectImage(image)

        assertEquals(image, viewModel.selectedImage.value)
    }

    @Test
    fun `deselectImage should clear selectedImage state flow`() {
        viewModel.deselectImage()

        assertEquals(null, viewModel.selectedImage.value)
    }
}
