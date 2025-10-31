package com.toyelabs.quotes.data

import android.content.Context
import android.util.Log
import java.io.InputStreamReader
import com.google.gson.Gson
import com.toyelabs.quotes.R

class LocalQuotesDataSource(private val context: Context) : QuotesDataSource {
    override suspend fun getQuotes(): Quote {
        return try {
            val inputStream = context.resources.openRawResource(R.raw.quotes)
            val reader = InputStreamReader(inputStream)
            val quotes = Gson().fromJson(reader, Array<Quote>::class.java)
            quotes?.random() ?: Quote(
                text = "In this world, it's an endless cycle of winning and losing - until you start losing your mind",
                author = "Ezra Jahad"
            )
        }
        catch (e: Exception) {
            Log.e("QuotesDataSource", "Failed to load quotes", e)

            Quote(
                text = "In this world, it's an endless cycle of winning and losing - until you start losing your mind",
                author = "Ezra Jahad"
            )
        }
    }
}
