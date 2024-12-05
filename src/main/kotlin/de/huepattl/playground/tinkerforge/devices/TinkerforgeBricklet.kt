package de.huepattl.playground.tinkerforge.devices

import com.tinkerforge.IPConnection

abstract class TinkerforgeBricklet(val uid: String, val connection: IPConnection) {
}