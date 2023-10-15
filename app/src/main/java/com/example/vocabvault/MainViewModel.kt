package com.example.vocabvault

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vocabvault.domain.WordFactory

class MainViewModel : ViewModel() {

    val addText = MutableLiveData("Add")
    val originalWordHint = MutableLiveData("Original Word")
    val translatedWordHint = MutableLiveData("Translated Word")

    private val _visibility = MutableLiveData<Int>()
    private val _originalWordText = MutableLiveData<String>()
    private val _translatedWordText = MutableLiveData<String>()

    private val _windowDisplayed = MutableLiveData<Boolean>()

    private val windowDisplayed: LiveData<Boolean>
        get() = _windowDisplayed

    val visibility: LiveData<Int>
        get() = _visibility

    val originalWordText: LiveData<String>
        get() = _originalWordText

    val translatedWordText: LiveData<String>
        get() = _translatedWordText



    private fun updateVisibility(visibility: Int) {
        _visibility.value = visibility
    }

    fun updateOriginalWord(originalWord: String) {
        _originalWordText.value = originalWord
    }

    fun updateTranslatedWord(translatedWord: String) {
        _translatedWordText.value = translatedWord
    }

    private fun changeWindowDisplayed() {
        _windowDisplayed.value = _windowDisplayed.value != true
    }

    fun onAdd() {
        if (windowDisplayed.value == true) {
            addWord(originalWordText.value.toString(), translatedWordText.value.toString())
            updateOriginalWord("")
            updateTranslatedWord("")
            updateVisibility(View.INVISIBLE)
            changeWindowDisplayed()
        } else {
            updateVisibility(View.VISIBLE)
            changeWindowDisplayed()
        }
    }

    private fun addWord(originalWord: String, translatedWord: String) {
        WordFactory.insert.addWord(WordFactory.dictionary, originalWord, translatedWord)
        WordFactory.adapter.notifyDataSetChanged()
    }

    init {
        _visibility.value = View.INVISIBLE
        _windowDisplayed.value = false
    }
}