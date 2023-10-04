package com.example.vocabvault.domain

class WordFactory {
    companion object {
        var dictionary = WordBook()
        var insert = AddWord()
        lateinit var adapter: WordAdapter
    }
}