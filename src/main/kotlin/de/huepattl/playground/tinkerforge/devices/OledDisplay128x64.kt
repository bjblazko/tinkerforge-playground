package de.huepattl.playground.tinkerforge.devices

import com.tinkerforge.BrickletOLED128x64V2
import de.huepattl.playground.tinkerforge.TinkerforgeDeviceConnection

class OledDisplay128x64(val connection: TinkerforgeDeviceConnection) {

    private var oled: BrickletOLED128x64V2? = null

    init {
        oled = BrickletOLED128x64V2(connection.uid, connection.connection.getConnection())
    }

    fun clear() {
        oled!!.clearDisplay()
        oled!!.writeLine(0, 0, "Hello, OLED 128x64!")
    }
}