package com.example.data.repositories

import com.example.domain.entity.Word

object WordsListSingleton {

    val list: MutableList<Word> = mutableListOf(
            Word("cześć", mutableListOf("привет")),
            Word("proszę", mutableListOf("прошу", "пожалуйста")),
            Word("tak", mutableListOf("да")),
            Word("nie", mutableListOf("нет")),
            Word("oczewiście", mutableListOf("конечно", "очевидно")),
            Word("chętnie", mutableListOf("охотно")),
            Word("cwiczenie", mutableListOf("упражнение")),
            Word("drobiazg", mutableListOf("мелочь")),
            Word("świetnie", mutableListOf("прекрасно")),
            Word("spoko", mutableListOf("спокойно")),
            Word("zły", mutableListOf("злой")),
            Word("kotek", mutableListOf("кот")))
}