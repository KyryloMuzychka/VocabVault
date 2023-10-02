package com.example.vocabvault

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.vocabvault.domain.AddWord
import com.example.vocabvault.domain.Word
import com.example.vocabvault.domain.WordAdapter
import com.example.vocabvault.domain.WordBook

class MainActivity : AppCompatActivity() {

    private var windowDisplayed = false

    private lateinit var addButton: Button
    private lateinit var listView: ListView
    private lateinit var background: View

    private lateinit var dictionary: WordBook
    private lateinit var insert: AddWord
    private lateinit var adapter: WordAdapter
    private lateinit var translatedWordEdit: EditText
    private lateinit var originalWordEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Initialize()
        setupUI()
    }

    private fun Initialize() {
        addButton = findViewById<Button>(R.id.addButton)
        listView = findViewById<ListView>(R.id.wordsListView)
        background = findViewById<View>(R.id.background)
        translatedWordEdit = findViewById<EditText>(R.id.translatedWordEdit)
        originalWordEdit = findViewById<EditText>(R.id.originalWordEdit)

        dictionary = WordBook()
        insert = AddWord()
        adapter = WordAdapter(this, R.layout.list_item_layout, dictionary.getAllWords())
        listView.adapter = adapter
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
        val word = Word(originalWord, translatedWord)
        insert.addWord(dictionary, word)
        adapter.notifyDataSetChanged()
    }

    private fun clearEdits() {
        originalWordEdit.text.clear()
        translatedWordEdit.text.clear()
    }

    private fun hideEdits() {
        originalWordEdit.setVisibility(View.INVISIBLE)
        translatedWordEdit.setVisibility(View.INVISIBLE)
        background.setVisibility(View.INVISIBLE)
    }

    private fun showEdits() {
        originalWordEdit.setVisibility(View.VISIBLE)
        translatedWordEdit.setVisibility(View.VISIBLE)
        background.setVisibility(View.VISIBLE)
    }
}