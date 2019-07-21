package com.home.androidviewpager2demo.cards

class Card private constructor(val name: String, val position: String) {

    companion object {
        const val TAIWAN = "台灣"
        const val SOUTH_AFRICA = "南非"
        const val UNITED_STATES = "美國"
        const val NEW_ZEALAND = "紐西蘭"
        const val FIRST_ATTRACTION = "景點一"
        const val SECOND_ATTRACTION = "景點二"
        private val NAME = setOf(TAIWAN, SOUTH_AFRICA, UNITED_STATES, NEW_ZEALAND)
        private val POSITION = setOf(FIRST_ATTRACTION, SECOND_ATTRACTION)
        // flatMap: 遍歷每一個元素，並合併成一個集合
        // map: 遍歷每一個元素
        val DATA = NAME.flatMap { suit ->
            POSITION.map { value ->
                Card(suit, value)
            }
        }
    }
}
