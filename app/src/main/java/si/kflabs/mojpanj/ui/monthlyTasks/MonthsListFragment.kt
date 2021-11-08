package si.kflabs.mojpanj.ui.monthlyTasks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import si.kflabs.mojpanj.R
import si.kflabs.mojpanj.data.domain.BeeTask
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
    val scrollState = rememberScrollState()
    Scaffold() {
        Column(modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Mesečna opravila",
                style = MaterialTheme.typography.h4,
                modifier =Modifier.padding(vertical = 8.dp)
            )

            Column(
                modifier = Modifier
                    .background(Gray200)
                ,
                ) {
                LazyRow {
                    items(items = BeeTaskMonth.values()) { month ->
                        MonthCard(
                            title = month.title.substring(0..2).uppercase(),
                            modifier = Modifier
                                .weight(.3f)
                                .clickable { onMonthChanged(month) },
                            isSelected = (month == selectedMonth)
                        )
                    }
                }
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                ) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = selectedMonth.title,
                            style = MaterialTheme.typography.h5,
                        )
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(items = selectedMonth.tasks) { task ->
                                MonthlyTaskListItem(task = task)
                            }
                            item {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .padding(top = 16.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Button(
                                        onClick = { /*TODO*/ },
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
                            item {
                                Spacer(modifier = Modifier
                                    .height(128.dp)
                                    .fillMaxWidth())
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MonthlyTaskListItem(task: BeeTask) {
    var checked by remember { mutableStateOf(false) }
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it  }
            )
            Text(
                text = task.title,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun MonthCard(
    title: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    Card(
        modifier = modifier
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = if(isSelected) MaterialTheme.colors.primary else Color.White,
        border = BorderStroke(2.dp, MaterialTheme.colors.primary)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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



