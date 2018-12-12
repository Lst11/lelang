package com.example.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.example.data.db.utils.Converter

@Entity(tableName = "word")
data class WordDB(
        @PrimaryKey
        val wordPL: String,
        @TypeConverters(Converter::class)
        val wordRU: List<String>
)

