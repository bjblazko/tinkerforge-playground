package de.huepattl.playground.tinkerforge

import com.tinkerforge.IPConnection
import de.huepattl.playground.tinkerforge.devices.OledDisplay128x64
import java.time.Duration

fun main() {
    println("Hello World!")
    val connection = IPConnection()
    connection.connect("localhost", 4223)

    val oled = OledDisplay128x64("NTV", connection)
    oled.clear()

    Thread.sleep(Duration.ofSeconds(5))

    connection.disconnect()
}