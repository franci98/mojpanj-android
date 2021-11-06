package si.kflabs.mojpanj.ui.monthlyTasks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import si.kflabs.mojpanj.R
import java.time.Month

class MonthsListFragment : Fragment() {
    private val viewModel: MonthsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MonthsListFragmentScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MonthsListFragmentScreen(viewModel: MonthsListViewModel) {

}

@Composable
fun MonthsListScreen(
    months: List<Month>
) {
    Scaffold {
        Column {
            Row {

            }
        }
    }
}

@Composable
fun MonthCard(
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 8.dp,
        modifier = modifier
            .padding(),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(text = title)
        }
    }
}

@Preview
@Composable
fun MonthCardPreview() {
    MonthCard(title = "Januar")
}



