package com.example.vocabvault.Exceptions

class EmptyFieldException(fieldName: String) : Exception("$fieldName cannot be empty.")