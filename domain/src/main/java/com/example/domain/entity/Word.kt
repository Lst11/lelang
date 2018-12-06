package com.example.domain.entity

data class Word(val wordPL: String,
                val wordRU: MutableList<String>) : DomainEntity