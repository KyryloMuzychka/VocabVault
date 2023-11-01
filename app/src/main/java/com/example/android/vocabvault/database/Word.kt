
package com.example.android.vocabvault.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(
    @ColumnInfo(name = "originalWord") val originalWord: String,
    @ColumnInfo(name = "translatedWord") val translatedWord: String)
{
    @PrimaryKey(autoGenerate = true)
    var Id: Int = 0
}
