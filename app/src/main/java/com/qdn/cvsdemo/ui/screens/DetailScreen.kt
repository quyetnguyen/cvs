package com.qdn.cvsdemo.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.qdn.cvsdemo.data.model.FlickrImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(image: FlickrImage, onBack: () -> Unit) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val painter = rememberAsyncImagePainter(image.imageUrl)
            Image(
                painter = painter,
                contentDescription = image.title,
                modifier = Modifier
                    .width(image.width.dp)
                    .height(image.height.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(text = "Title: ${image.title}")
            Text(text = "Width: ${image.width}")
            Text(text = "Height: ${image.height}")
            Text(text = "Published: ${image.published}")
            Text(text = "Tags: ${image.tags}")

            Spacer(modifier = Modifier.height(16.dp))

            FilledTonalButton(
                onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(
                            Intent.EXTRA_TEXT,
                            """
                            Check out this image!
                            Title: ${image.title}
                            Tags: ${image.tags}
                            URL: ${image.imageUrl}
                            """.trimIndent()
                        )
                    }
                    context.startActivity(Intent.createChooser(shareIntent, "Share via"))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Share")
            }
        }
    }
}