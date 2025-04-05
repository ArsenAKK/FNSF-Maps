package com.example.fnsf_maps.ui.informacoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InformacoesViewModel : ViewModel() {
    // Example: A LiveData to hold some text
    private val _someText = MutableLiveData<String>()
    val someText: LiveData<String> = _someText
    init {
        // Initialize the text (might fetch it from a repository instead)
        _someText.value = "Initial text for Informacoes"
    }
    // Example: A function to update the text
    fun updateText(newText: String) {
        _someText.value = newText
    }
}