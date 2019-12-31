package com.kimi.roomwords.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kimi.roomwords.room.Word
import com.kimi.roomwords.room.WordRepository
import com.kimi.roomwords.room.WordRoomDatabase
import kotlinx.coroutines.launch

/**
 * Created by Kimi.Peng on 2019-12-30.
 */
class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository

    val allWords: LiveData<List<Word>>


    init {
        val wordsDao = WordRoomDatabase.getInstance(application, viewModelScope).wordDao()

        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch{
        repository.insert(word = word)
    }

}