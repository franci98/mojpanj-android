package si.kflabs.mojpanj.ui.education

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import si.kflabs.mojpanj.R
import si.kflabs.mojpanj.data.domain.EducationCategory
import si.kflabs.mojpanj.ui.beehives.BeehivesListFragmentScreen
import si.kflabs.mojpanj.ui.theme.Brown
import si.kflabs.mojpanj.ui.theme.MojPanjTheme

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
}

@Composable
fun EducationCategoriesListFragmentScreen(viewModel: EducationCategoriesListViewModel) {
    EducationCategoriesListScreen()
}

@Composable
fun EducationCategoriesListScreen() {
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
                EducationCategory.values().forEach { educationCategory ->
                    Button(
                        onClick = {

                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Brown),
                        shape = RoundedCornerShape(40.dp)
                    ) {
                        Text(
                            text = educationCategory.name,
                            style = MaterialTheme.typography.h4
                        )
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
        EducationCategoriesListScreen()
    }
}