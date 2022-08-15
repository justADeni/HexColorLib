package com.github.justadeni

import net.md_5.bungee.api.ChatColor

object HexColorLib {

    /**
     * Function takes in a String with 0,
     * 1 or 2 hex color codes in #aabbcc format
     * which it then uses to color the rest of the String
     */
    fun String.color(): String {
        when (this.count{it == '#'}) {
            1 -> {
                val messages = this.split("#")
                val startTag = messages[1].take(6)
                val newmessage = this.replace("#$startTag", "")

                val r1 = startTag.substring(0, 2).rgb() ?: return this
                val g1 = startTag.substring(2, 4).rgb() ?: return this
                val b1 = startTag.substring(4, 6).rgb() ?: return this

                var returnMessage = ""

                returnMessage += ChatColor.of(
                    java.awt.Color(r1.toInt(), g1.toInt(), b1.toInt())
                )
                returnMessage += newmessage

                return returnMessage
            }
            2 -> {
                val messages = this.split("#")
                val startTag = messages[1].take(6)
                val endTag = messages[2].take(6)
                val newmessage = this.replace("#$startTag", "").replace("#$endTag", "")

                var r1 = startTag.substring(0, 2).rgb() ?: return this//171
                var g1 = startTag.substring(2, 4).rgb() ?: return this//76
                var b1 = startTag.substring(4, 6).rgb() ?: return this//55

                val r2 = endTag.substring(0, 2).rgb() ?: return this//255
                val g2 = endTag.substring(2, 4).rgb() ?: return this//1
                val b2 = endTag.substring(4, 6).rgb() ?: return this//1

                val lenght = newmessage.length.toDouble() //31

                val incrementR = (r1 - r2) / lenght
                val incrementG = (g1 - g2) / lenght
                val incrementB = (b1 - b2) / lenght

                var returnMessage = ""
                for (i in 0 until lenght.toInt()) {
                    returnMessage += ChatColor.of(
                        java.awt.Color(r1.toInt(), g1.toInt(), b1.toInt())
                    )
                    returnMessage += newmessage[i]

                    r1 -= incrementR //255
                    g1 -= incrementG //1
                    b1 -= incrementB //1
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
    private fun String.rgb(): Double? {
        return try {
            this.toInt(16).toDouble()
        } catch (e : java.lang.NumberFormatException) {
            null
        }
    }
}