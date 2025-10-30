package com.toyelabs.quotes.data

interface QuotesDataSource {
    suspend fun getQuotes(): Quote
}
