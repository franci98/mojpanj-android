package si.kflabs.mojpanj.ui.monthlyTasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import si.kflabs.mojpanj.data.domain.BeeTaskMonth
import java.time.Month
import java.util.*

class MonthsListViewModel : ViewModel() {
    val months: LiveData<List<BeeTaskMonth>> = MutableLiveData(BeeTaskMonth.values().toList())

    val _selectedMonth : MutableLiveData<BeeTaskMonth> = MutableLiveData()
    val selectedMonth: LiveData<BeeTaskMonth> = _selectedMonth

    init {
        val date = Calendar.getInstance()
        val month: BeeTaskMonth = BeeTaskMonth.values()[date.get(Calendar.MONTH)]
        this.selectMonth(month = month)
    }

    fun selectMonth(month: BeeTaskMonth) {
        _selectedMonth.postValue(month)
    }
}