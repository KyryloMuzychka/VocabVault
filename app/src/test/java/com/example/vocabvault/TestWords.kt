package com.example.vocabvault

import com.example.vocabvault.Exceptions.EmptyFieldException
import com.example.vocabvault.Exceptions.ExistingWordException
import com.example.vocabvault.domain.AddWord
import com.example.vocabvault.domain.Word
import com.example.vocabvault.domain.WordBook
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestWords {

    private lateinit var dictionary: WordBook
    private lateinit var word1: Word
    private lateinit var word2: Word
    private lateinit var word3: Word
    private lateinit var add: AddWord

    @Before
    fun setup() {
        dictionary = WordBook()
        word1 = Word("apple", "яблоко")
        word2 = Word("", "ми")
        word3 = Word("we", "")
        add = AddWord()
    }

    /**
     * Перевіряє виникнення помилки при додаванні слова, якщо таке слово вже додано раніше
     * Рwезультат: зʼявляється виключення
     * [ExistingWordException]
     */
    @Test
    fun test_AddWord_AlreadyExists() {
        // перевіряємо, щоб кількість слів була 0
        Assert.assertEquals(0, dictionary.getAmountOfWords())

        add.addWord(dictionary, word1)

        // перевіряємо, щоб кількість слів була 1
        Assert.assertEquals(1, dictionary.getAmountOfWords())

        // додаємо таке саме слово вдруге
        try {
            add.addWord(dictionary, word1)
        } catch(ex: ExistingWordException) {
            println(ex)
        }
    }

    /**
     * Перевіряє додавання слова з пустими полями
     * Результат: Зʼявляється виключення
     * [EmptyFieldException]
     */
    @Test
    fun test_AddWord_EmptyOriginalWord() {
        // перевіряємо, щоб кількість слів була 0
        Assert.assertEquals(0, dictionary.getAmountOfWords())

        add.addWord(dictionary, word1)

        // перевіряємо, щоб кількість слів була 1
        Assert.assertEquals(1, dictionary.getAmountOfWords())

        // додаємо слово без заповнених полів
        try {
            add.addWord(dictionary, word2)
        } catch(ex: EmptyFieldException) {
            println(ex)
        }
    }

    @Test
    fun test_AddWord_EmptyTranslatedWord() {
        // перевіряємо, щоб кількість слів була 0
        Assert.assertEquals(0, dictionary.getAmountOfWords())

        add.addWord(dictionary, word1)

        // перевіряємо, щоб кількість слів була 1
        Assert.assertEquals(1, dictionary.getAmountOfWords())

        // додаємо слово без заповнених полів
        try {
            add.addWord(dictionary, word3)
        } catch(ex: EmptyFieldException) {
            println(ex)
        }
    }

    @Test
    fun test_AddWord_Successful() {
        // перевіряємо, щоб кількість слів була 0
        Assert.assertEquals(0, dictionary.getAmountOfWords())

        add.addWord(dictionary, word1)

        // перевіряємо, щоб кількість слів була 1
        Assert.assertEquals(1, dictionary.getAmountOfWords())

        // Перевіряємо, що слово "apple" дійсно додане до словника з правильним перекладом "яблоко"
        val addedWord = dictionary.getAllWords().find { it.originalWord == word1.originalWord }

        Assert.assertNotNull(addedWord)
        Assert.assertEquals(word1.translatedWord, addedWord?.translatedWord)

        println(addedWord)
    }
}