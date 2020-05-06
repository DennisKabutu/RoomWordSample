package com.globomed.roomwordsample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
/* A @Dao annotations identifies it as Dao class for Room
* Daos must be either be interface or abstract class
*  */
interface WordDao{
    /*  The onConflict strategy used ignores a new word if its exactly the same as one
    * already in the list */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords():LiveData<List<Word>>
    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}

