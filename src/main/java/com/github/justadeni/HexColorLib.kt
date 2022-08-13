package com.github.justadeni

import net.md_5.bungee.api.ChatColor
import java.lang.Exception

object HexColorLib {

    fun String.color(): String {

        when (this.count{it == '#'}) {
            1 -> {
                val messages = this.split("#")
                var startTag = messages[1].take(6)
                val newmessage = this.replace("#$startTag", "")
                startTag = startTag.uppercase()

                val r1 = hexToRgb(startTag.substring(0, 2))
                val g1 = hexToRgb(startTag.substring(2, 4))
                val b1 = hexToRgb(startTag.substring(4, 6))

                if (r1 == -1 || g1 == -1 || b1 == -1)
                    return this

                var returnMessage = ""
                //val lenght = newmessage.length.toDouble()

                var currentR = r1.toDouble()
                currentR = checkBounds(currentR)
                var currentG = g1.toDouble()
                currentG = checkBounds(currentG)
                var currentB = b1.toDouble()
                currentB = checkBounds(currentB)

                returnMessage += ChatColor.of(
                    java.awt.Color(
                        currentR.toInt(),
                        currentG.toInt(),
                        currentB.toInt()
                    )
                )
                returnMessage += newmessage

                return returnMessage
            }
            2 -> {


                val messages = this.split("#")
                var startTag = messages[1].take(6)
                var endTag = messages[2].take(6)
                val newmessage = this.replace("#$startTag", "").replace("#$endTag", "")
                startTag = startTag.uppercase()
                endTag = endTag.uppercase()

                val r1 = hexToRgb(startTag.substring(0, 2)) //171
                val g1 = hexToRgb(startTag.substring(2, 4)) //76
                val b1 = hexToRgb(startTag.substring(4, 6)) //55

                if (r1 == -1 || g1 == -1 || b1 == -1)
                    return this

                val r2 = hexToRgb(endTag.substring(0, 2)) //255
                val g2 = hexToRgb(endTag.substring(2, 4)) //1
                val b2 = hexToRgb(endTag.substring(4, 6)) //1

                if (r2 == -1 || g2 == -1 || b2 == -1)
                    return this

                var returnMessage = ""
                val lenght = newmessage.length.toDouble() //31

                var currentR = r1.toDouble() //171
                currentR = checkBounds(currentR)
                var currentG = g1.toDouble() //76
                currentG = checkBounds(currentG)
                var currentB = b1.toDouble() //55
                currentB = checkBounds(currentB)

                val incrementR = ((r1 - r2) / lenght)
                val incrementG = ((g1 - g2) / lenght)
                val incrementB = ((b1 - b2) / lenght)

                for (i in 0 until lenght.toInt()) {
                    returnMessage += ChatColor.of(
                        java.awt.Color(
                            currentR.toInt(),
                            currentG.toInt(),
                            currentB.toInt()
                        )
                    )
                    returnMessage += newmessage[i]

                    currentR -= incrementR //255
                    currentR = checkBounds(currentR)

                    currentG -= incrementG //1
                    currentG = checkBounds(currentG)

                    currentB -= incrementB //1
                    currentB = checkBounds(currentB)
                }

                return returnMessage
            }
            else -> {
                return ChatColor.translateAlternateColorCodes('&',this)
            }
        }
    }

    //converts 2 char strings to 0-255 numbers
    //or -1 in case of an error
    private fun hexToRgb(hex: String): Int {
        val num1 = getNum(hex[0])
        val num2 = getNum(hex[1])
        if (num1 == -1 || num2 == -1)
            return -1

        return num1 * 16 + num2
    }

    //converts one char to corresponding numerical value
    private fun getNum(num: Char): Int {
        return try {
            when (num) {
                'A' -> 10
                'B' -> 11
                'C' -> 12
                'D' -> 13
                'E' -> 14
                'F' -> 15
                else -> num.digitToInt()
            }
        } catch (e : Exception){
            -1
        }
    }

    //checks if number isn't over treshold (due to possible innacuracies
    //and sets it to valid color values
    private fun checkBounds(num: Double): Double {
        return if (num > 255)
            255.0
        else if (num < 0)
            0.0
        else
            num
    }
    //test commit
}