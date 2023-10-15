package com.example.vocabvault

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vocabvault.databinding.ActivityMainBinding
import com.example.vocabvault.domain.WordAdapter
import com.example.vocabvault.domain.WordFactory

class MainActivity : AppCompatActivity() {



    private var windowDisplayed = false

    private lateinit var addButton: Button
    private lateinit var listView: ListView
    private lateinit var background: View
    private lateinit var translatedWordEdit: EditText
    private lateinit var originalWordEdit: EditText

    private lateinit var mainViewModel : MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        binding.viewModel = this.mainViewModel



        Initialize()
        setupUI()

    }

    private fun Initialize() {
        addButton = findViewById<Button>(R.id.addButton)
        listView = findViewById<ListView>(R.id.wordsListView)
        background = findViewById<View>(R.id.background)
        translatedWordEdit = findViewById<EditText>(R.id.translatedWordEdit)
        originalWordEdit = findViewById<EditText>( R.id.originalWordEdit)

        WordFactory.adapter = WordAdapter(this, R.layout.list_item_layout, WordFactory.dictionary.getAllWords())
        listView.adapter = WordFactory.adapter
    }

    private fun setupUI() {
        addButton.setOnClickListener {
            if (windowDisplayed) {
                val originalWord = originalWordEdit.getText().toString()
                val translatedWord = translatedWordEdit.getText().toString()
                addWord(originalWord, translatedWord)
                clearEdits()
                hideEdits()
                windowDisplayed = false
            } else {
                showEdits()
                windowDisplayed = true
            }
        }
    }

    private fun addWord(originalWord: String, translatedWord: String) {
        WordFactory.insert.addWord(WordFactory.dictionary, originalWord, translatedWord)
        WordFactory.adapter.notifyDataSetChanged()
    }

    private fun clearEdits() {
        originalWordEdit.text.clear()
        translatedWordEdit.text.clear()
    }

    private fun hideEdits() {
        mainViewModel.updateVisibility(View.INVISIBLE)
    }

    private fun showEdits() {
        mainViewModel.updateVisibility(View.VISIBLE)
    }
}