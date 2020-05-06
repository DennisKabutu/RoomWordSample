package com.globomed.roomwordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "word_table")
/* Each @Entity class represents a Sql lite table
* Annotate your class declaration to indicate that its an entity */
data class Word (@PrimaryKey @ColumnInfo(name = "word") val word:String)