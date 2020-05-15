package com.globomed.roomwordsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordViewModel(application: Application):AndroidViewModel(application){

    //Hold reference of the Repository
    private val repository:WordRepository

    val allWords:LiveData<List<Word>>

    init {
        //Get the Database
        val wordDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        //Pass the Database to the Repository which is a required parameter
        repository= WordRepository(wordDao)
        allWords= repository.allWords
    }

    fun insertWord(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }

}