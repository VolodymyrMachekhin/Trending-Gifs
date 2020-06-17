package com.vmac.giphy.network.client

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.io.Reader

fun getStringFromJson(jsonFile: String): String {
        var responseString = ""
        try {
            var path = System.getProperty("user.dir") ?: ""
            path = "$path/src/test/java/com/example/getyourguide/network/client/$jsonFile"
            val file = File(path)
            val fileInputStream = FileInputStream(file)
            val reader = BufferedReader(InputStreamReader(fileInputStream) as Reader?)
            val stringBuilder = StringBuilder()
            var line: String?
            line = reader.readLine()
            while (line != null) {
                stringBuilder.append(line)
                line = reader.readLine()
                if (line != null) {
                    stringBuilder.append("\n")
                }
            }
            reader.close()
            fileInputStream.close()
            responseString = stringBuilder.toString()
        } catch (exception: Exception) {
            exception.printStackTrace()
        } finally {
            return responseString
        }
    }