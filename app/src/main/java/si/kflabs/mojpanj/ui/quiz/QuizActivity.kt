package si.kflabs.mojpanj.ui.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.ui.theme.Gray800
import si.kflabs.mojpanj.ui.theme.MojPanjTheme

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MojPanjTheme() {
                Scaffold {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Kviz",
                            style = MaterialTheme.typography.h5
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            (1..3).forEach { _ ->
                                Card(
                                    elevation = 8.dp,
                                    shape = RoundedCornerShape(16.dp),
                                ) {
                                    Column(modifier = Modifier
                                        .padding(8.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Text(
                                            text = "Kdaj se dogaja čistilni izlet čebel?",
                                            style = MaterialTheme.typography.h4
                                        )

                                        Text(
                                            text = "a) Maj",
                                            style = MaterialTheme.typography.subtitle1
                                        )
                                        Text(
                                            text = "b) Februar",
                                            style = MaterialTheme.typography.subtitle1
                                        )
                                        Text(
                                            text = "c) Marec",
                                            style = MaterialTheme.typography.subtitle1
                                        )
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
                                                Icon(Icons.Default.Check, contentDescription = null, tint = Gray800)
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