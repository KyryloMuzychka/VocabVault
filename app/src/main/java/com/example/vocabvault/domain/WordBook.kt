package com.example.vocabvault.domain

import com.example.vocabvault.Exceptions.NoWordsException

/**
 * Клас, який містить словник, що зберігає слова з їх перекладами, та різні методи, що стосуютьсята отримання кількості слів у словнику.
 */
class WordBook {
    private var wordbook = mutableListOf<Word>()

    /**
     * Дії: Повертає словник
     * @throws NoWordsException if [wordbook] not empty
     */
    fun getAllWords(): MutableList<Word> {
        assert(getAmountOfWords() > 0) {
            "Wordbook is empty."
        }

        return if (getAmountOfWords() > 0) {
            wordbook
        } else {
            throw NoWordsException()
        }
    }

    /**
     * Дії: Повертає кількість слів у словнику
     * @throws NoWordsException if [wordbook] not empty
     */
    fun getAmountOfWords(): Int {
        return wordbook.size
    }
}

fun Test()
{
    val dictionary = WordBook()

    val word = Word("apple", "яблоко")

    val add = AddWord()

    add.addWord(dictionary, word);
}








