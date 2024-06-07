package br.com.cvsassessment.ui.composables


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailItem(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "$label:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
    }
}