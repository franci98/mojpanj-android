package si.kflabs.mojpanj.ui.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import si.kflabs.mojpanj.data.domain.BeeTaskMonth
import si.kflabs.mojpanj.data.domain.model.EducationArticle
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.ui.monthlyTasks.MonthCard
import si.kflabs.mojpanj.ui.theme.Gray800
import si.kflabs.mojpanj.ui.theme.MojPanjTheme

@AndroidEntryPoint
class EducationArticlesListActivity : AppCompatActivity() {
    val viewModel: EducationArticlesListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        return setContent {
                MojPanjTheme() {
                    EducationArticlesListFragmentScreen(viewModel = viewModel)
                }
            }
        }

    @Composable
    private fun EducationArticlesListFragmentScreen(viewModel: EducationArticlesListViewModel) {
        val educationArticles by viewModel.educationArticles.observeAsState(initial = Resource.Loading)
        EducationArticlesListScreen(articles = educationArticles)
    }

    @Composable
    private fun EducationArticlesListScreen(articles: Resource<List<EducationArticle>>) {
        val scrollState = rememberScrollState()
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                (articles as? Resource.Success)?.value?.let { articles ->
                    var selectedArticle by remember { mutableStateOf(articles.first()) }
                    LazyRow {
                        items(items = articles) { article ->
                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .clickable { selectedArticle = article },
                                backgroundColor = if(selectedArticle.id == article.id) MaterialTheme.colors.primary else Color.White,
                                border = BorderStroke(2.dp, MaterialTheme.colors.primary)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = article.title,
                                        color = Gray800,
                                        style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold),
                                    )
                                }
                            }
                        }
                    }
                    selectedArticle.let { article ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(horizontal = 16.dp),
                            elevation = 8.dp,
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = article.title,
                                    style = MaterialTheme.typography.subtitle1
                                )
                                Text(
                                    text = article.content,
                                    style = MaterialTheme.typography.body1
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}