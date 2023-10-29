package com.example.android.vocabvault.exceptions

class EmptyFieldException(fieldName: String) : Exception("$fieldName cannot be empty.")