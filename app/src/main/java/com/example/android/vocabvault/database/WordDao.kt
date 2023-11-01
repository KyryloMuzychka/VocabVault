package com.example.android.vocabvault.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.vocabvault.database.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY originalWord ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("SELECT * FROM word_table WHERE originalWord = :value")
    suspend fun findWordByValue(value: String): Word?

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}
