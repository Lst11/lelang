package com.example.data.db.utils

import android.arch.persistence.room.TypeConverter
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


class Converter {
    var gson = Gson()

    @TypeConverter
    fun convertJsonToList(data: String?): List<String> {
        Log.e("aaa", "Converter - convertJsonToList")
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun convertListToJson(list: List<String>): String {
        Log.e("aaa", "Converter - convertListToJson")
        return gson.toJson(list)
    }
}