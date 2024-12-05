package de.huepattl.playground.tinkerforge

import com.tinkerforge.IPConnection
import de.huepattl.playground.tinkerforge.devices.OledDisplay128x64
import java.time.Duration

fun main(args: Array<String>) {
    println("Hello World!")
    val connection = TinkerforgeConnection()

    val oled = OledDisplay128x64(TinkerforgeDeviceConnection(connection, "NTV"))
    oled.clear()

    Thread.sleep(Duration.ofSeconds(5))

    connection.getConnection().disconnect()
}

data class TinkerforgeConnection(
    val host: String = "localhost",
    val port: Int = 4223
) {
    private val ipconn = IPConnection()

    init {
        ipconn.connect(host, port)
    }

    fun getConnection() = ipconn
}

data class TinkerforgeDeviceConnection(
    val connection: TinkerforgeConnection,
    val uid: String
)