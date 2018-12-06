package com.example.data.entity

import com.google.gson.annotations.SerializedName

class WordResponse(
        @SerializedName("code")
        val code: Int,

        @SerializedName("lang")
        val lang: String,

        @SerializedName("text")
        val listOfWords: List<String>
) : DataEntity