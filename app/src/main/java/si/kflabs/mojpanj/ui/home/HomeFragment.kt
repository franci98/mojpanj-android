package si.kflabs.mojpanj.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint
import hu.ma.charts.pie.LegendPosition
import hu.ma.charts.pie.PieChart
import hu.ma.charts.pie.PieChartData
import hu.ma.charts.pie.PieChartEntry
import si.kflabs.mojpanj.R
import si.kflabs.mojpanj.data.domain.model.Post
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.ui.monthlyTasks.MonthsListFragmentScreen
import si.kflabs.mojpanj.ui.theme.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MojPanjTheme() {
                    HomeFragmentScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun HomeFragmentScreen(viewModel: HomeViewModel) {
    val posts by viewModel.posts.observeAsState(initial = Resource.Loading)
    HomeScreen(posts = posts)
}

@Composable
fun HomeScreen(
    posts: Resource<List<Post>>
) {
    Scaffold {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Pozdravljen, Franci \uD83D\uDC4B",
                    style = MaterialTheme.typography.h3,
                )

                Text(
                    text = "Bodi priden kot \uD83D\uDC1D!",
                    style = MaterialTheme.typography.caption.copy(fontSize = 22.sp),
                    color = Gray500,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            TasksCompletedCard()



            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Zadnje iz bloga",
                    style = MaterialTheme.typography.h5
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = 8.dp,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                    ) {
                        Image(
                            painter = rememberImagePainter("https://www.czs.si/Upload/800x400/CEBELE%20(32).jpg"),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentScale = ContentScale.FillBounds
                        )
                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(
                                text = "Api Seminar",
                                style = MaterialTheme.typography.subtitle1
                            )
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun TasksCompletedCard() {
    Row(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Card(
            elevation = 8.dp
        ) {
            Box {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colors.primary),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Column(
                        modifier = Modifier.rotate(90.0f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Naloge",
                            style = MaterialTheme.typography.subtitle1,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                        )
                        Box(modifier = Modifier
                            .height(2.dp)
                            .width(64.dp)
                            .background(Gray800)
                        ) {}
                    }

                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .height(150.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(32.dp)
                                .fillMaxWidth(.4f)
                        ) {
                            PieChart(
                                data = PieChartData(
                                    entries = listOf(0.6f, 0.4f).mapIndexed { idx, value ->
                                        PieChartEntry(
                                            value = value,
                                            label = AnnotatedString("hi")
                                        )
                                    },
                                    colors = listOf(true, false).mapIndexed { _, value -> if (value) MaterialTheme.colors.primary else Gray200 },
                                    legendPosition = LegendPosition.End,
                                    legendShape = CircleShape,
                                ),
                                legend = {

                                },
                            )
                        }

                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text(
                                text = "Opravljene \nnaloge",
                                style = MaterialTheme.typography.subtitle1
                            )

                            Text(
                                text = "6 / 10 nalog",
                                style = MaterialTheme.typography.caption,
                                color = Gray600
                            )
                        }
                    }
                }
            }
        }
    }

}
