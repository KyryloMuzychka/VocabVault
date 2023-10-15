package com.example.vocabvault

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.vocabvault.databinding.ActivityMainBinding
import com.example.vocabvault.domain.WordAdapter
import com.example.vocabvault.domain.WordFactory


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel : MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    private fun initialize() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel

        binding.translatedWordEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mainViewModel.updateTranslatedWord(s.toString()) // Update LiveData when the text changes.
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        binding.originalWordEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mainViewModel.updateOriginalWord(s.toString()) // Update LiveData when the text changes.
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        WordFactory.adapter = WordAdapter(this, R.layout.list_item_layout, WordFactory.dictionary.getAllWords())
        binding.wordsListView.adapter = WordFactory.adapter
    }

}