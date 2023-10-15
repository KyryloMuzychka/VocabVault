package com.example.vocabvault

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val addText = MutableLiveData("Add")
}