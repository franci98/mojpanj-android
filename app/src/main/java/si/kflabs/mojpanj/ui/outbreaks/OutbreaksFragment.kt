package si.kflabs.mojpanj.ui.outbreaks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import si.kflabs.mojpanj.R
import si.kflabs.mojpanj.data.remote.Resource
import com.google.android.gms.maps.CameraUpdateFactory
import kotlinx.android.synthetic.main.outbreaks_fragment.*
import si.kflabs.mojpanj.ui.theme.MojPanjTheme
import com.google.android.gms.maps.model.CircleOptions

import com.google.android.gms.maps.model.Circle





@AndroidEntryPoint
class OutbreaksFragment : Fragment(), OnMapReadyCallback {
    private val viewModel: OutbreaksViewModel by viewModels()
    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.outbreaks_fragment, container, false)

        return view
    }

    override fun onResume() {
        super.onResume()
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        bottomContainer.setContent {
            MojPanjTheme() {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .padding(bottom = 64.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Card(
                        elevation = 8.dp
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                Icons.Default.HouseSiding,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(64.dp)
                                    .padding(16.dp)
                            )
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Kranj 1",
                                    style = MaterialTheme.typography.subtitle2
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(start = 2.dp)
                                ) {
                                    Icon(
                                        Icons.Default.FiberManualRecord,
                                        contentDescription = null,
                                        tint = Color.Green,
                                        modifier = Modifier
                                            .scale(0.7f)
                                    )
                                }
                            }
                            Button(
                                onClick = { /*TODO*/ },
                            ) {
                                Icon(Icons.Default.Coronavirus, contentDescription = null)
                            }
                        }
                    }
                    Card(elevation = 8.dp) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                Icons.Default.HouseSiding,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(64.dp)
                                    .padding(16.dp)
                            )
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Novo Mesto",
                                    style = MaterialTheme.typography.subtitle2
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(start = 2.dp)
                                ) {
                                    Icon(
                                        Icons.Default.FiberManualRecord,
                                        contentDescription = null,
                                        tint = Color.Red,
                                        modifier = Modifier
                                            .scale(0.7f)
                                    )
                                }
                            }
                            Button(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.buttonColors()
                            ) {
                                Icon(Icons.Default.Coronavirus, contentDescription = null)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map
        viewModel.outbreaks.observe(viewLifecycleOwner) { resource ->
            (resource as? Resource.Success)?.value?.let { outbreaks ->
                outbreaks.forEach { outbreak ->
                    this.map.addMarker(
                        MarkerOptions()
                            .position(LatLng(outbreak.apiary.lat, outbreak.apiary.lon))
                            .title(outbreak.apiary.kmgMid)
                    )
                    this.map.addCircle(
                        CircleOptions()
                            .center(LatLng(outbreak.apiary.lat, outbreak.apiary.lon))
                            .radius(10000.0)
                            .strokeColor(R.color.black)
                            .fillColor(R.color.yellow)
                    )
                }
                this.map.animateCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        LatLng(	46.056946, 14.505751), 8.0f
                    )
                )
            }
        }
    }

}