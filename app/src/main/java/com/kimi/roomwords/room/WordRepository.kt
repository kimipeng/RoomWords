package com.kimi.roomwords.room

import android.os.AsyncTask
import androidx.lifecycle.LiveData

/**
 * Created by Kimi.Peng on 2019-12-30.
 */
class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()


    fun insert(word: Word) {
        AsyncTask.execute {
            wordDao.insert(word = word)
        }
    }



}
