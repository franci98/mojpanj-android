package si.kflabs.mojpanj.ui.monthlyTasks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import si.kflabs.mojpanj.R
import si.kflabs.mojpanj.data.domain.BeeTaskMonth
import java.time.Month

class MonthsListFragment : Fragment() {
    private val viewModel: MonthsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
    months: List<BeeTaskMonth>
) {
    Scaffold {
        Column(modifier = Modifier
            .fillMaxWidth()
        ) {
            for (i in 0..5) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Column(modifier = Modifier
                        .weight(.5f)
                        .padding(4.dp)
                    ) {
                        MonthCard(
                            title = months[i * 2].name
                        )
                    }
                    Column(modifier = Modifier
                        .weight(.5f)
                        .padding(4.dp)
                    ) {
                        MonthCard(
                            title = months[i * 2 + 1].name
                        )
                    }
                }
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
            .padding(4.dp),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.primary
            )
        }
    }
}

@Preview
@Composable
fun MonthsListScreenPreview() {
    MonthsListScreen(months = BeeTaskMonth.values().toList())
}



