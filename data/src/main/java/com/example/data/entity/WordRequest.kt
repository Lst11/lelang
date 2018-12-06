package com.example.data.entity

import com.google.gson.annotations.SerializedName

class WordRequest(
        @SerializedName("text")
        val wordPL: String,

        @SerializedName("lang")
        val lang: String = "pl-ru",

        @SerializedName("key")
        val key: String = "trnsl.1.1.20181022T115847Z.0a64ecf3c3a11871.f14f0c5ea2594cf08f54e7a16d8b5aebf1d4fbaf") : DataEntity
