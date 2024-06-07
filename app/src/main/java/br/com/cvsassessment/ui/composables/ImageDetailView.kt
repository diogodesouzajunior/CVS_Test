package br.com.cvsassessment.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.cvsassessment.data.model.FlickerItem
import coil.compose.rememberImagePainter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ImageDetailView(image: FlickerItem) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val painter = rememberImagePainter(data = image.media.m)
        Image(
            painter = painter,
            contentDescription = image.title,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.00f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        DetailItem(label = "Title", value = image.title)
        DetailItem(label = "Description", value = removeHtmlTags(image.description))
        DetailItem(label = "Author", value = image.author)
        DetailItem(label = "Published", value = formatDate(image.published))
    }
}

fun removeHtmlTags(html: String): String {
    return html.replace(Regex("<.*?>"), "")
}

fun formatDate(dateString: String): String {
    return try {
        val apiDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val date: Date? = apiDateFormat.parse(dateString)
        val localeDateFormat =
            SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG, Locale.getDefault())
        if (date != null) localeDateFormat.format(date) else dateString
    } catch (e: Exception) {
        dateString
    }
}
