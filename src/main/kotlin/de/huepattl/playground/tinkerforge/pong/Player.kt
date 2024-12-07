package de.huepattl.playground.tinkerforge.pong

data class Player(
    val id: Int,
    var points: Int,
    var caretPosition: Int,
)
