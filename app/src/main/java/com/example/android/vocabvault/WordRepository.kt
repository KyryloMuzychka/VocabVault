
package com.example.android.vocabvault

import android.content.Context
import android.widget.Toast
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word, context: Context) {
        val existingWord = wordDao.findWordByValue(word.originalWord)
        if (existingWord == null) {
            wordDao.insert(word)
        } else {
            val message = "The word '${word.originalWord}' already exists."
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}
