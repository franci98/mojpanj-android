package si.kflabs.mojpanj.ui.education

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import si.kflabs.mojpanj.R
import si.kflabs.mojpanj.ui.beehives.BeehivesListFragmentScreen

class EducationCategoriesListFragment : Fragment() {

    private val viewModel: EducationCategoriesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                EducationCategoriesListFragmentScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun EducationCategoriesListFragmentScreen(viewModel: EducationCategoriesListViewModel) {

}

@Composable
fun EducationCategoriesListScreen() {
    Scaffold {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        ) {
            Text(
                text = "Priročnik",
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@Composable
@Preview
fun EducationCategoriesListScreenPreview() {
    EducationCategoriesListScreen()
}