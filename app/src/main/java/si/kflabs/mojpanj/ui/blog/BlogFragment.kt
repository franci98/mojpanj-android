package si.kflabs.mojpanj.ui.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint
import si.kflabs.mojpanj.data.domain.model.Post
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.ui.theme.Gray200
import si.kflabs.mojpanj.ui.theme.Gray300
import si.kflabs.mojpanj.ui.theme.Gray600
import si.kflabs.mojpanj.ui.theme.MojPanjTheme
import si.kflabs.mojpanj.utils.toSimpleString

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
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Blog",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )

            when (posts) {
                is Resource.Failure -> Text(text = "Network error")
                Resource.Loading -> Text(text = "Loading")
                is Resource.Success -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier
                            .background(Gray200)
                            .padding(bottom = 8.dp, top = 8.dp)
                            .padding(horizontal = 8.dp)
                    ) {
                        items(posts.value) { post ->
                            BlogPostListItem(
                                post = post
                            )
                        }
                        item {
                            Spacer(modifier = Modifier
                                .height(128.dp)
                                .fillMaxWidth())
                        }
                    }
                }
            }
         }
    }
}

@Composable
fun BlogPostListItem(
    post: Post,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.TopStart
        ) {
            Box(modifier = Modifier
                .fillMaxWidth(0.25f)
                .height(82.dp)
                .background(MaterialTheme.colors.primary)
            )
            Row {
                Image(
                    painter = rememberImagePainter("https://www.czs.si/Upload/800x400/CEBELE%20(32).jpg"),
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp)
                        .padding(10.dp)
                        .border(4.dp, Color.White),
                    contentScale = ContentScale.FillHeight
                )
                Column(
                    modifier = Modifier
                        .height(128.dp)
                        .padding(top = 16.dp, start = 4.dp, end = 8.dp, bottom = 8.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = post.title,
                        style = MaterialTheme.typography.subtitle1,
                        maxLines = 2
                    )
                    Text(
                        text = post.createdAt.toSimpleString(),
                        style = MaterialTheme.typography.caption,
                        maxLines = 2,
                        color = Gray600
                    )
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

