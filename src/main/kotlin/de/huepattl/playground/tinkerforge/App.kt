package de.huepattl.playground.tinkerforge

import com.tinkerforge.BrickletOLED128x64V2
import com.tinkerforge.BrickletRotaryEncoderV2
import com.tinkerforge.IPConnection
import de.huepattl.playground.tinkerforge.pong.Player
import de.huepattl.playground.tinkerforge.pong.PongGame

fun main() {
    val connection = IPConnection()
    connection.connect("localhost", 4223)

    pong()

    connection.disconnect()
}

fun pong() {
    print("Hello, Pong!")

    val connection = IPConnection()
    connection.connect("localhost", 4223)

    val oled2 = BrickletOLED128x64V2("NTV", connection)
    val rotary = BrickletRotaryEncoderV2("XDU", connection)

    val playerOne = Player(1, 0, 0)
    val playerTwo = Player(2, 0, 0)

    val game = PongGame(oled2, rotary, playerOne, playerTwo)

    game.play(250)
}