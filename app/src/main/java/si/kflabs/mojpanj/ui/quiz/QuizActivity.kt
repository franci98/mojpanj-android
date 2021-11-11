package si.kflabs.mojpanj.ui.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import si.kflabs.mojpanj.data.remote.Resource
import si.kflabs.mojpanj.ui.theme.Gray300
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
                        .background(MaterialTheme.colors.primary),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Kviz",
                            style = MaterialTheme.typography.h4,
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .padding(bottom = 16.dp, top = 16.dp)
                        )
                        Card(
                            modifier = Modifier.fillMaxSize(),
                            shape = RoundedCornerShape(32.dp, 32.dp, 0.dp, 0.dp)
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 16.dp, vertical = 16.dp),
                                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Icon(
                                            Icons.Default.CheckCircle,
                                            contentDescription = null,
                                            tint = Color(0xFF74CB00)
                                        )
                                        Text(text = "2",
                                            style = MaterialTheme.typography.subtitle2)
                                    }
                                    Column(
                                        modifier = Modifier.fillMaxWidth(.4f),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(text = "4/6",
                                            style = MaterialTheme.typography.subtitle2)
                                        LinearProgressIndicator(progress = (4f / 6))
                                    }
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Icon(
                                            Icons.Default.Cancel,
                                            contentDescription = null,
                                            tint = Color(0xFFFF333D)
                                        )
                                        Text(text = "1",
                                        style = MaterialTheme.typography.subtitle2)
                                    }
                                }

                                Text(
                                    text = "Kdaj se dogaja čistilni izlet čebel?",
                                    style = MaterialTheme.typography.h4,
                                    modifier = Modifier
                                        .padding(horizontal = 32.dp),
                                    textAlign = TextAlign.Center
                                )

                                Card(
                                    elevation = 8.dp,
                                    shape = RoundedCornerShape(16.dp),
                                ) {
                                    Text(
                                        text = "Maj",
                                        style = MaterialTheme.typography.subtitle1,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(Gray300)
                                            .padding(vertical = 16.dp),
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Card(
                                    elevation = 8.dp,
                                    shape = RoundedCornerShape(16.dp),
                                ) {
                                    Text(
                                        text = "Februar",
                                        style = MaterialTheme.typography.subtitle1,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(Gray300)
                                            .padding(vertical = 16.dp),
                                        textAlign = TextAlign.Center

                                    )

                                }
                                Card(
                                    elevation = 8.dp,
                                    shape = RoundedCornerShape(16.dp),
                                ) {
                                    Text(
                                        text = "Marec",
                                        style = MaterialTheme.typography.subtitle1,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(Gray300)
                                            .padding(vertical = 16.dp),
                                        textAlign = TextAlign.Center

                                    )
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}