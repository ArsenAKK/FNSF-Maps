package com.example.fnsf_maps.ui.definicoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DefinicoesViewModel : ViewModel() {
    // Example: A LiveData to hold a setting value (boolean)
    private val _settingEnabled = MutableLiveData<Boolean>()
    val settingEnabled: LiveData<Boolean> = _settingEnabled
    init {
        // Initialize the setting (might load it from preferences)
        _settingEnabled.value = false
    }
    // Example: A function to toggle the setting
    fun toggleSetting() {
        _settingEnabled.value = !_settingEnabled.value!!
    }
}