package com.example.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.data.db.entity.WordDB
import io.reactivex.Flowable

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg wordDB: WordDB)

    @Query("SELECT * FROM word  ORDER BY wordPL")
    fun getAll(): Flowable<List<WordDB>>

}