package com.example.placementholder

import PlaceHolderRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlacementHolderTheme {

                var placeholderPost: Post? by remember {
                    mutableStateOf(null)
                }
                var comments: Comment? by remember {
                    mutableStateOf(null)
                }
                var albums: Album? by remember {
                    mutableStateOf(null)
                }
                val post = Post(body ="my body", id = 1,title = "my post", userId = 1)

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(top = 100.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally

                        //modifier = Modifier.padding(innerPadding)
                    ) {
                        Button(
                            modifier = Modifier.padding(25.dp),
                            onClick = {
                                lifecycleScope.launch(Dispatchers.IO) {
                                    placeholderPost =
                                        PlaceHolderRepository().placeholderNetworkCall()
                                }
                            }) {
                            Text(
                                "Fetch Posts",
                                fontSize = 25.sp
                            )
                        }
                            .let {
                                Text(
                                    placeholderPost?.toString() ?: "No Data",
                                    fontSize = 25.sp
                                )
                            }

                        Button(
                            modifier = Modifier.padding(25.dp),
                            onClick = {
                                lifecycleScope.launch(Dispatchers.IO) {
                                    comments = PlaceHolderRepository().getComments()
                                    PlaceHolderRepository().createPost(post)
                                }
                            }) {
                            Text(
                                "Fetch Comments",
                                fontSize = 25.sp
                            )
                        }
                            .let {
                                Text(
                                    comments?.toString() ?: "No Data",
                                    fontSize = 25.sp
                                )
                            }
                    }
                }
            }
        }
    }
}





