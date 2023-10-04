package com.example.vocabvault.domain

import com.example.vocabvault.Exceptions.EmptyFieldException
import com.example.vocabvault.Exceptions.ExistingWordException

/**
 * Додає слово
 */
class AddWord() {
    /**
     * Вимагає: словник та слово з не пустими оригіналом та перекладом
     *
     * Дії: Додає слово з оригіналом і перекладом до словника
     *
     * Змінює: словник
     *
     * @param word обʼєкт класу [Word], який додається до словника [wordbook]
     * @param dictionary обʼєкт класу [WordBook]
     *
     * @throws EmptyFieldException if [originalWord] or [translatedWord] == ""
     * @throws ExistingWordException if [wordbook] has [word]
     */
    fun addWord(dictionary: WordBook, originalWord: String, translatedWord: String) {
        val amount = dictionary.getAmountOfWords()

        if (originalWord.isBlank()) {
            throw EmptyFieldException("original word")
        }
        if (translatedWord.isBlank()) {
            throw EmptyFieldException("translated word")
        }
        if (dictionary.getAllWords().any { it.originalWord == originalWord }) {
            throw ExistingWordException(originalWord)
        }
        val word = Word(originalWord, translatedWord)
        dictionary.getAllWords().add(word)

        assert(amount + 1 == dictionary.getAmountOfWords())
    }
}