package com.example.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.example.data.db.dao.WordDao
import com.example.data.db.entity.WordDB
import com.example.data.db.utils.Converter

@Database(entities = [WordDB::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "nameDB"

        fun getInstance(context: Context): AppDataBase {

            return Room
                    .databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration() //если версии отличаются текущую удалит и создает новую
                    .allowMainThreadQueries()// ?
                    .build()
        }
    }

    abstract fun getWordDao(): WordDao

}