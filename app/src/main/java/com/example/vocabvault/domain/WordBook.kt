package com.example.vocabvault.domain

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
       return wordbook
    }

    /**
     * Дії: Повертає кількість слів у словнику
     * @throws NoWordsException if [wordbook] not empty
     */
    fun getAmountOfWords(): Int {
        return wordbook.size
    }
}







