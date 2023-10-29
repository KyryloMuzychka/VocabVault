package com.example.android.vocabvault.exceptions

class ExistingWordException(word: String) : Exception("$word already exists.")