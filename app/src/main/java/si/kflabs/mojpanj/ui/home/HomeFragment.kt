package si.kflabs.mojpanj.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import si.kflabs.mojpanj.R
import si.kflabs.mojpanj.ui.monthlyTasks.MonthsListFragmentScreen
import si.kflabs.mojpanj.ui.theme.MojPanjTheme

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MojPanjTheme() {
                    HomeFragmentScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun HomeFragmentScreen(viewModel: HomeViewModel) {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Scaffold {
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Pozdravljen, Franci!",
                style = MaterialTheme.typography.h4
            )

            Card(
                elevation = 8.dp,
                modifier = Modifier
            ) {
                Text(
                    text = "Eno jabolko na dan odžene zdravnika stran!",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center
                )
            }

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Opravila ta mesec",
                    style = MaterialTheme.typography.h6
                )

                Card(
                    elevation = 8.dp,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = "Očistiti sneg",
                            modifier = Modifier,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Priprava satnic",
                            modifier = Modifier,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Zadnje iz bloga",
                    style = MaterialTheme.typography.h6
                )


            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MojPanjTheme() {
        HomeScreen()
    }
}