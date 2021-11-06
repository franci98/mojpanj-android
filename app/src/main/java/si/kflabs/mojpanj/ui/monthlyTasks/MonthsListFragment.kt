package si.kflabs.mojpanj.ui.monthlyTasks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import si.kflabs.mojpanj.R
import si.kflabs.mojpanj.data.domain.BeeTaskMonth
import si.kflabs.mojpanj.ui.theme.*
import java.time.Month

class MonthsListFragment : Fragment() {
    private val viewModel: MonthsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MojPanjTheme {
                    MonthsListFragmentScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun MonthsListFragmentScreen(viewModel: MonthsListViewModel) {
    val months by viewModel.months.observeAsState(initial = emptyList())
    val selectedMonth by viewModel.selectedMonth.observeAsState(initial = BeeTaskMonth.JANUARY)
    MonthsListScreen(
        months = months,
        selectedMonth = selectedMonth,
        onMonthChanged = viewModel::selectMonth
    )
}

@Composable
fun MonthsListScreen(
    months: List<BeeTaskMonth>,
    selectedMonth: BeeTaskMonth,
    onMonthChanged: (BeeTaskMonth) -> Unit
) {
    Scaffold() {
        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Mesečna opravila",
                style = MaterialTheme.typography.h4
            )
            LazyRow {
                items(items = BeeTaskMonth.values()) { month ->
                    MonthCard(
                        title = month.title.substring(0..2).uppercase(),
                        modifier = Modifier
                            .weight(.3f)
                            .size(64.dp)
                            .clickable { onMonthChanged(month) }
                    )
                }
            }
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
            ) {
                Card(backgroundColor = Gray200) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                    ) {
                        Text(
                            text = selectedMonth.title,
                            style = MaterialTheme.typography.h6,
                        )
                        selectedMonth.tasks.forEach { task ->
                            Text(
                                text = task.title,
                                style = MaterialTheme.typography.subtitle1,
                            )
                            Text(text = task.description,
                                    style = MaterialTheme.typography.body1,
                            )
                        }
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
        modifier = modifier
            .padding(4.dp),
        backgroundColor = Gray300
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                tint = Gray800
            )
            Text(
                text = title,
                color = Gray800,
                style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold),
            )
        }
    }
}

@Preview
@Composable
fun MonthsListScreenPreview() {
    MojPanjTheme {
        MonthsListScreen(
            months = BeeTaskMonth.values().toList(),
            selectedMonth = BeeTaskMonth.JANUARY,
            onMonthChanged = {}
        )
    }
}



