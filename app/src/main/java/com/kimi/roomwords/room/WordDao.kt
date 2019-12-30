package com.kimi.roomwords.room

import androidx.room.Insert
import androidx.room.Query

/**
 * Created by Kimi.Peng on 2019-12-30.
 */

interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): List<Word>

}