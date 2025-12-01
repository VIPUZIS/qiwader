package ru.vipuzis.qiwader

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val vm = MainViewModel()
    var count = 0
    var multiple = 1
    val isUsedBoostClicks = 0
    val isUsedBoostAutoclicker = 0
    val isUsedBoostPassiveIncome = 0
    fun Plus(multiple: Int): Int {
        return 1*multiple
    }
}