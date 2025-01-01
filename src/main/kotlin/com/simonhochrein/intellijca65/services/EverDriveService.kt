package com.simonhochrein.intellijca65.services

import com.fazecast.jSerialComm.SerialPort
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationGroupManager
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.MessageType
import com.simonhochrein.intellijca65.utils.EverDriveCommand
import io.ktor.util.date.*
import kotlinx.coroutines.CoroutineScope
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.*
import kotlin.experimental.and
import kotlin.experimental.xor

@Service(Service.Level.PROJECT)
class EverDriveService(val project: Project, val cs: CoroutineScope) {
    private var serialPort: SerialPort? = null
    private var io = EverDriveIO()

    fun getStatus() =
        withConnection {
            io.getStatus()
        }
    fun getRTC() = withConnection { io.getRTC() }

    private fun <T> withConnection(action: () -> T): T? {
        if (serialPort == null || serialPort?.isOpen == false) {
            if (!openConnection()) {
                EverDriveNotifier.connectionError(project, "Failed to open serial port")
                return null
            }
        }
        try {
            return action()
        } catch (e: Exception) {
            EverDriveNotifier.connectionError(project, "Failed to run command")
            return null
        }
    }

    private fun openConnection(): Boolean {
        for (port in SerialPort.getCommPorts()) {
            if (port.portDescription == "EverDrive N8") {
                serialPort = port.apply {
                    openPort()
                    setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1000, 1000)
                }
                disableServiceMode()
                return true
            }
        }
        return false
    }

    private fun disableServiceMode() {
        if (!io.isServiceMode()) return

        io.exitServiceMode()
        Thread.sleep(1000)

        if(openConnection()) {
            io.getStatus()
        } else {
            EverDriveNotifier.connectionError(project, "Failed to restart device")
        }
    }


    inner class EverDriveIO {
        fun getStatus(): Boolean {
            command(EverDriveCommand.STATUS)

            return readShort() and 0xff00.toShort() == 0xa500.toShort()
        }

        fun isServiceMode(): Boolean {
            command(EverDriveCommand.GET_MODE)
            return readByte() == 0xA1.toByte()
        }

        fun exitServiceMode() {
            command(EverDriveCommand.RUN_APP)
        }

        fun getRTC(): Date {
            command(EverDriveCommand.RTC_GET)

            val year = readByte().bcd() + 2000
            val month = readByte().bcd()
            val day = readByte().bcd()
            val hour = readByte().bcd()
            val minute = readByte().bcd()
            val second = readByte().bcd()


            return GregorianCalendar().let {
                it.set(year, month-1, day, hour, minute, second)
                it.time
            }
        }

        private fun command(command: EverDriveCommand) {
            write('+'.code.toByte(), '+'.code.toByte() xor 0xff, command.code, command.code xor 0xff)
        }

        private fun readByte(): Byte {
            val result = ByteArray(1)
            serialPort!!.readBytes(result, 1)
            return result[0]
        }

        private fun readShort(): Short {
            val result = ByteArray(2)
            serialPort!!.readBytes(result, 2)
            return ByteBuffer.wrap(result).order(ByteOrder.LITTLE_ENDIAN).getShort()
        }

        private fun write(vararg bytes: Byte) {
            writeByteArray(bytes)
        }
        private fun writeByteArray(array: ByteArray) {
            serialPort!!.writeBytes(array, array.size)
        }
    }

    companion object {
        @JvmStatic
        fun getInstance(project: Project): MyProjectService = project.service()
    }

}

object EverDriveNotifier {
    fun connectionError(project: Project, reason: String) {
        NotificationGroupManager.getInstance().getNotificationGroup("EverDrive")
            .createNotification(reason, MessageType.ERROR).setSubtitle("EverDrive connection error")
            .notify(project)
    }
}

private infix fun Byte.xor(other: Int) = this xor other.toByte()

private fun Byte.bcd(): Int = ((this.toInt() shr 4) and 0x0F) * 10 + (this and 0x0F)