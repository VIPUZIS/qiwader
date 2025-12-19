package ru.vipuzis.qiwader.data.model

import android.app.Application
import android.content.Context
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = application.getSharedPreferences("main", Context.MODE_PRIVATE)
    private val _count = MutableLiveData<Int>()

    private val isNotFirstLaunch = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

    private val _multiple = MutableLiveData<Int>()

    var isIsedAutoclickerPrice = MutableLiveData<Boolean>()
    var isUsedBostsClicksPrice = MutableLiveData<Boolean>()
    var isUserBostsIncomePrice = MutableLiveData<Boolean>()

    init {
        val saved = preferences.getInt("count", 0)
        _count.value = saved
    }

    fun plus() {
        val newValue = (_count.value ?: 0) + 1
        _count.value = newValue
        preferences.edit { putInt("count", newValue) }
    }
}