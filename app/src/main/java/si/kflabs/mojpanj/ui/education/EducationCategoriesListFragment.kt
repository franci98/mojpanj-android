package si.kflabs.mojpanj.ui.education

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import si.kflabs.mojpanj.data.domain.model.EducationCategory
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.ui.theme.Brown
import si.kflabs.mojpanj.ui.theme.Gray800
import si.kflabs.mojpanj.ui.theme.MojPanjTheme

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

    @Composable
    fun EducationCategoriesListFragmentScreen(viewModel: EducationCategoriesListViewModel) {
        val educationCategories by viewModel.educationCategories.observeAsState(initial = Resource.Loading)
        EducationCategoriesListScreen(
            educationCategories = educationCategories,
            onEducationCategoryClick = this::openEducationCategoryClick
        )
    }
}


@Composable
fun EducationCategoriesListScreen(
    educationCategories: Resource<List<EducationCategory>>,
    onEducationCategoryClick: (EducationCategory) -> Unit
) {
    Scaffold {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Priročnik",
                style = MaterialTheme.typography.h5
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                (educationCategories as? Resource.Success)?.value?.forEach { educationCategory ->

                        Card(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(16.dp),
                        ) {
                            Column(modifier = Modifier
                                .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = educationCategory.title,
                                    style = MaterialTheme.typography.h4
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .padding(top = 16.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Button(
                                        onClick = { onEducationCategoryClick(educationCategory) },
                                        shape = RoundedCornerShape(40.dp)
                                    ) {
                                        Icon(Icons.Default.MoreHoriz, contentDescription = null, tint = Gray800)
                                    }
                                    Button(
                                        onClick = { /*TODO*/ },
                                        shape = RoundedCornerShape(40.dp)
                                    ) {
                                        Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Gray800)
                                        Text(text = "Play")
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
        EducationCategoriesListScreen(educationCategories = Resource.Loading, onEducationCategoryClick = {})
    }
}