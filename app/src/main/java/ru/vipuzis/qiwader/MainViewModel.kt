package ru.vipuzis.qiwader

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = application.getSharedPreferences("main", Context.MODE_PRIVATE)
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

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