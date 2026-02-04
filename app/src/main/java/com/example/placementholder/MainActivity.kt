package com.example.placementholder

import PlaceHolderRepository
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.placementholder.ui.theme.PlacementHolderTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.System.console

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApiUi()
        }
    }
    @Composable
    fun ApiUi() {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(top = 100.dp)
                    .fillMaxSize(),
                 ) {

                var placeholderPost: Post? by remember {
                    mutableStateOf(null)
                }
                var comments: Comment? by remember {
                    mutableStateOf(null)
                }
                var albums: Album? by remember {
                    mutableStateOf(null)
                }

                var displayText by remember { mutableStateOf("Click a button to load data") }

                Column(
                    modifier = Modifier
                        .padding()
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = {
                            lifecycleScope.launch(Dispatchers.IO) {
                                placeholderPost =
                                    PlaceHolderRepository().getPost()
                                displayText =
                                    "Post: ${placeholderPost?.title}\n${placeholderPost?.body}"
                            }
                        }) { Text("Get Post") }

                        Button(onClick = {
                            lifecycleScope.launch(Dispatchers.IO) {
                                comments =
                                    PlaceHolderRepository().getComments()
                                displayText =
                                    "Comments: ${comments?.name}\n${comments?.body}"
                            }
                        }) { Text("Get Comment") }

                        Button(onClick = {
                            lifecycleScope.launch(Dispatchers.IO) {
                                albums = PlaceHolderRepository().getAlbums()
                                displayText = "Album: ${albums?.title}"
                            }
                        }) { Text("Get Album") }
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = {
                            lifecycleScope.launch(Dispatchers.IO) {
                                val newPost = Post("new body", 0, "New Title", 1)
                                val created =
                                    PlaceHolderRepository().createPost(newPost)
                                displayText = "Created Post ID: ${created?.id}"
                            }
                        }) { Text("Create Post") }

                        Button(onClick = {
                            lifecycleScope.launch(Dispatchers.IO) {
                                PlaceHolderRepository().deletePost(5)
                                displayText = "Post deleted successfully"
                            }
                        }) { Text("Delete Post") }

                        Button(onClick = {
                            lifecycleScope.launch(Dispatchers.IO) {
                                val patched = PlaceHolderRepository().patchPost(
                                    5,
                                    Post(
                                        "Patched Body",
                                        1,
                                        "Patched Title",
                                        1
                                    )
                                )
                                displayText = "Patched Post: ${patched?.title}"
                            }
                        }) { Text("Patch Post") }

                        Button(onClick = {
                            lifecycleScope.launch(Dispatchers.IO) {
                                val put = PlaceHolderRepository().putPost(
                                    5,
                                    Post(
                                        "Patched Body",
                                        1,
                                        "Patched Title",
                                        1
                                    )
                                )
                                displayText = "Put Post: ${put?.title}"
                            }
                        }) { Text("Patch Post") }
                    }

                    OutlinedTextField(
                        value = displayText,
                        onValueChange = { displayText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        label = { Text("Response Data") }
                    )
                }
            }
        }
    }
}









