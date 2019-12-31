package com.kimi.roomwords.room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Kimi.Peng on 2019-12-30.
 */

@Entity(tableName = "word_table")
class Word(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    var word: String

)