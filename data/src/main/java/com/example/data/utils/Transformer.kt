package com.example.data.utils

import com.example.data.entity.WordResponse
import com.example.domain.entity.Word

object Transformer {
    //    fun transformIdToRequest(id: String?): String {
//        return "id=${id}"
//    }
//
//    fun transformNameToRequest(name: String?): String {
//        return "name LIKE'${name}%'"
//    }
//
    fun transformResponseToDomain(wordPL: String, wordResponse: WordResponse): Word {
        return Word(wordPL, wordResponse.listOfWords.toMutableList())
    }
}