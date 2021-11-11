package si.kflabs.mojpanj.ui.outbreaks

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                    BeehiveListItem(
                        title = "Čebelnjak v Kranju",
                        color = Color(0xFF74CB00)
                    )
                    BeehiveListItem(
                        title = "Čebelnjak na Ptuju",
                        color = Color(0xFFFF333D)
                    )
                }
            }
        }
    }

    @Composable
    fun BeehiveListItem(title: String, color: Color) {
        Card(elevation = 8.dp) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Box(modifier = Modifier
                    .width(10.dp)
                    .height(100.dp)
                    .background(color = color)
                ) {

                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_hive),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(16.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier.fillMaxWidth(.6f)
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Icon(Icons.Default.Coronavirus, contentDescription = null)
                    }
                }
            }
        }
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(46.056946, 14.505751), 7.0f))
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
                            .radius(5000.0)
                            .fillColor(R.color.yellow)
                            .strokeColor(R.color.black)
                    )
                }
            }
        }
    }

}