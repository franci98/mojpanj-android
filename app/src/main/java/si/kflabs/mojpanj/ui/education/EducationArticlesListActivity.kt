package si.kflabs.mojpanj.ui.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import si.kflabs.mojpanj.data.domain.model.EducationArticle
import si.kflabs.mojpanj.data.remote.Resource
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
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                (articles as? Resource.Success)?.value?.forEach { article ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        elevation = 8.dp,
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(
                                text = article.title,
                                style = MaterialTheme.typography.subtitle1
                            )
                            Text(
                                text = article.content,
                                style = MaterialTheme.typography.body1,
                                maxLines = 4
                            )
                        }
                    }
                }
            }
        }
    }
}