package de.huepattl.playground.tinkerforge.devices

import com.tinkerforge.BrickletOLED128x64V2
import com.tinkerforge.IPConnection

class OledDisplay128x64(uid: String, connection: IPConnection) : TinkerforgeBricklet(uid, connection) {

    private val bricklet = BrickletOLED128x64V2(super.uid, super.connection)

    fun clear() {
        bricklet.clearDisplay()
        bricklet.writeLine(0, 0, "Hello, OLED 128x64!")
    }

 }