package de.huepattl.playground.tinkerforge.pong

import com.tinkerforge.BrickletOLED128x64V2
import com.tinkerforge.BrickletRotaryEncoderV2
import java.time.Duration

class PongGame(
    val screen: BrickletOLED128x64V2,
    val controller: BrickletRotaryEncoderV2,
    val playerOne: Player, val playerTwo: Player
) {

    init {
        controller.addCountListener { count -> playerOne.caretPosition = count }
        controller.setCountCallbackConfiguration(500, true, 'x', 0, 0)
        controller.getCount(true)
    }

    fun play(speed: Int) {
        while (true) {
            screen.clearDisplay()
            showPoints(playerOne.points, playerTwo.points)
            drawPlayer(playerOne)
            Thread.sleep(Duration.ofMillis(speed.toLong()))
        }
    }

    private fun showPoints(playerOne: Int, playerTwo: Int) {
        screen.writeLine(0, 0, "P1: $playerOne vs P2: $playerTwo")
    }

    private fun drawPlayer(player: Player) {
        screen.writeLine(player.caretPosition, 0, "|")
    }

}