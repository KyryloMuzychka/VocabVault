package com.example.vocabvault.Exceptions

class ExistingWordException(word: String) : Exception("$word already exists.")