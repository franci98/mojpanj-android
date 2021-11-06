package si.kflabs.mojpanj.ui.monthlyTasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import si.kflabs.mojpanj.data.domain.BeeTaskMonth
import java.time.Month

class MonthsListViewModel : ViewModel() {
    val months: LiveData<List<BeeTaskMonth>> = MutableLiveData(BeeTaskMonth.values().toList())
}