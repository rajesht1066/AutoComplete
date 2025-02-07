package com.example.autocomplete.model.data

data class Item(
    val address: Address,
    val highlights: Highlights,
    val houseNumberType: String,
    val id: String,
    val language: String,
    val resultType: String,
    val title: String
)