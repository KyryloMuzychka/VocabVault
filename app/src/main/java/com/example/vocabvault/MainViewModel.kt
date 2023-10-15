package com.example.vocabvault

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val addText = MutableLiveData("Add")
    val originalWordHint = MutableLiveData("Original Word")
    val translatedWordHint = MutableLiveData("Translated Word")

    private val _visibility = MutableLiveData<Int>()

    val visibility: LiveData<Int>
        get() = _visibility

    init {
        _visibility.value = View.INVISIBLE
    }

    fun updateVisibility(visibility: Int) {
        _visibility.value = visibility
    }


}