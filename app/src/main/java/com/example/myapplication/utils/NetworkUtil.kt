package com.example.myapplication.utils

import android.content.Context
import android.net.Uri
import com.example.myapplication.R
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.RuntimeException
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class NetworkUtil (private val context: Context) {

    fun generateURL(userId: String): URL {
        val tgURL = context.getString(R.string.tgURL)
        val botApi = context.getString(R.string.botApi)
        val chatId = context.getString(R.string.chatId)

        var buildUri: Uri  = Uri.parse(tgURL+botApi+"sendMessage").buildUpon()
                            .appendQueryParameter(chatId,userId)
                            .appendQueryParameter("text","sfsdfsdf")
                            .build()

        return URL(buildUri.toString())
    }

    fun getResponsFromURL(url: URL): String {
        val connection = url.openConnection() as HttpURLConnection

        val responseCode = connection.responseCode
        if(responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            val response = StringBuilder()
            var line: String
            while(reader.readLine().also { line = it } !=null) {
                response.append(line)
            }
            reader.close()
            return response.toString()
        } else {
            throw RuntimeException()
        }

    }

}