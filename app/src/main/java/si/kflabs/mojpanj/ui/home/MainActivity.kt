package si.kflabs.mojpanj.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import si.kflabs.mojpanj.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bottomNavigationView.background = null
    }
}