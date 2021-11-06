package si.kflabs.mojpanj.ui.beehives

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import si.kflabs.mojpanj.R

class BeehivesListFragment : Fragment() {

    companion object {
        fun newInstance() = BeehivesListFragment()
    }

    private lateinit var viewModel: BeehivesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.beehives_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BeehivesListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}