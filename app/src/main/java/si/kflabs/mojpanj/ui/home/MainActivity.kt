package si.kflabs.mojpanj.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import si.kflabs.mojpanj.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false

        setupGraph()
        fab.setOnClickListener {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.fragNavHost) as NavHostFragment
            val navController = navHostFragment.navController
            bottomNavigationView.selectedItemId = R.id.homeFragment
            navController.navigate(R.id.homeFragment)
        }
    }

    private fun setupGraph() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragNavHost) as NavHostFragment
        val navController = navHostFragment.navController
        val graphInflater = navHostFragment.navController.navInflater
        val navGraph = graphInflater.inflate(R.navigation.bottom_navigation_graph)
        navGraph.startDestination = R.id.homeFragment
        navController.graph = navGraph
        // Setting Navigation Controller with the BottomNavigationView
        bottomNavigationView.setupWithNavController(navController)
    }
}