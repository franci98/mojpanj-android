package si.kflabs.mojpanj.ui.education

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import si.kflabs.mojpanj.R

class EducationCategoriesListFragment : Fragment() {

    companion object {
        fun newInstance() = EducationCategoriesListFragment()
    }

    private lateinit var viewModel: EducationCategoriesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.education_categories_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EducationCategoriesListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}