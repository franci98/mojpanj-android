package si.kflabs.mojpanj.ui.education

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import si.kflabs.mojpanj.data.domain.model.EducationCategory
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.ui.quiz.QuizActivity
import si.kflabs.mojpanj.ui.theme.*

@AndroidEntryPoint
class EducationCategoriesListFragment : Fragment() {

    private val viewModel: EducationCategoriesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MojPanjTheme() {
                    EducationCategoriesListFragmentScreen(viewModel = viewModel)
                }
            }
        }
    }

    private fun openEducationCategoryClick(educationCategory: EducationCategory) {
        val intent = Intent(requireContext(), EducationArticlesListActivity::class.java)
        intent.putExtra("educationCategoryId", educationCategory.id)
        startActivity(intent)
    }

    private fun openQuizClick() {
        val intent = Intent(requireContext(), QuizActivity::class.java)
        startActivity(intent)
    }

    @Composable
    fun EducationCategoriesListFragmentScreen(viewModel: EducationCategoriesListViewModel) {
        val educationCategories by viewModel.educationCategories.observeAsState(initial = Resource.Loading)
        EducationCategoriesListScreen(
            educationCategories = educationCategories,
            onEducationCategoryClick = this::openEducationCategoryClick,
            onQuizClick = this::openQuizClick
        )
    }
}


@Composable
fun EducationCategoriesListScreen(
    educationCategories: Resource<List<EducationCategory>>,
    onEducationCategoryClick: (EducationCategory) -> Unit,
    onQuizClick: () -> Unit,
) {
    Scaffold {
        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Priročnik",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.9f)
                    .background(Gray200)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                (educationCategories as? Resource.Success)?.value?.let { educationCategories ->
                    (0 until (educationCategories.size / 2)).forEach { row ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            (0 until 2).forEach { col ->
                                educationCategories[row * 2 + col]?.let { educationCategory ->
                                    Card(
                                        elevation = 8.dp,
                                        shape = RoundedCornerShape(16.dp),
                                        modifier = Modifier
                                            .fillMaxWidth(.5f * (col + 1))
                                            .fillMaxHeight(.5f * (row + 1))
                                            .clickable { onEducationCategoryClick(educationCategory) }
                                    ) {
                                        Column(modifier = Modifier
                                            .padding(8.dp),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = educationCategory.title,
                                                style = MaterialTheme.typography.h6
                                            )
                                            Icon(educationCategory.icon,
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .size(100.dp)
                                                    .clip(CircleShape)
                                                    .background(MaterialTheme.colors.primary.copy(.3f))
                                                    .padding(32.dp)
                                                ,
                                                tint = MaterialTheme.colors.primary
                                            )
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(8.dp)
                                                    .padding(top = 16.dp),
                                            ) {
                                                Button(
                                                    onClick = { onQuizClick() },
                                                    shape = RoundedCornerShape(40.dp),
                                                    modifier = Modifier.fillMaxWidth()
                                                ) {
                                                    Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Gray800)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun EducationCategoriesListScreenPreview() {
    MojPanjTheme() {
        EducationCategoriesListScreen(educationCategories = Resource.Loading, onEducationCategoryClick = {}, onQuizClick = {})
    }
}