package com.kimi.roomwords.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Kimi.Peng on 2019-12-30.
 */

@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getInstance(context: Context): WordRoomDatabase {

            // Copy the current value of INSTANCE to a local variable so Kotlin can smart cast.
            // Smart cast is only available to local variables.
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            // Multiple threads can ask for the database at the same time, ensure we only initialize
            // it once by using synchronized. Only one thread may enter a synchronized block at a
            // time.
            synchronized(this) {
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()

                INSTANCE = instance
                return instance


            }
        }

    }
}