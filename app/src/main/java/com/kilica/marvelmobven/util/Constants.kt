package com.kilica.marvelmobven.util

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {
    const val API_KEY = "7c527ce4561927b2f0f2bf912dc6bd4f"
    const val PRIVATE_KEY = "fd1b546f96b7a26683237a6509bbef51db2f72d1"
    const val limit = "20"
    const val ID = "item_id"
    fun hash(): String {
        val input = "${getTimeStamp()}$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    fun getTimeStamp(): String {
        return Timestamp(System.currentTimeMillis()).time.toString()
    }
}
