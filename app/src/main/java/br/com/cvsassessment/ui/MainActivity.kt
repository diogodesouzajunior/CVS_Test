package br.com.cvsassessment.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.cvsassessment.ui.composables.SearchScreen
import br.com.cvsassessment.ui.viewmodel.ImageSearchViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: ImageSearchViewModel = viewModel()
            SearchScreen(viewModel = viewModel)
        }
    }
}
