package si.kflabs.mojpanj.ui.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import si.kflabs.mojpanj.data.domain.model.Post
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.ui.theme.MojPanjTheme

@AndroidEntryPoint
class BlogFragment : Fragment() {
    private val viewModel: BlogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MojPanjTheme() {
                    BlogFragmentScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun BlogFragmentScreen(viewModel: BlogViewModel) {
    val posts by viewModel.posts.observeAsState(initial = Resource.Loading)
    BlogScreen(
        posts = posts
    )
}

@Composable
fun BlogScreen(
    posts: Resource<List<Post>>
) {
    Scaffold {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        ) {
            Text(
                text = "Blog",
                style = MaterialTheme.typography.h4
            )

            when (posts) {
                is Resource.Failure -> Text(text = "Network error")
                Resource.Loading -> Text(text = "Loading")
                is Resource.Success -> {
                    LazyColumn {
                        items(posts.value) { post ->
                            Text(text = post.title)
                            Text(text = post.shortDescription)
                        }
                    }
                }
            }
         }
    }
}

@Composable
@Preview
fun BlogScreenPreview() {
    BlogScreen(posts = Resource.Success(emptyList()))
}

