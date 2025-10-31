package com.toyelabs.quotes.ui.widgets

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.text.FontStyle
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import com.toyelabs.quotes.data.LocalQuotesDataSource
import com.toyelabs.quotes.data.Quote

class QuotesWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val quote = LocalQuotesDataSource(context).getQuotes();
        provideContent {
            MyContent(quote)
        }
    }

    @Composable
    private fun MyContent(quote: Quote) {
        GlanceTheme {
            Column(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .background(GlanceTheme.colors.background)
                    .padding(8.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Text(
                    text = quote.text,
                    modifier = GlanceModifier.padding(12.dp),
                    style = TextStyle(
                        color = GlanceTheme.colors.onBackground
                    )
                )
                Text(
                    text = quote.author,
                    modifier = GlanceModifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        color = GlanceTheme.colors.onBackground,
                        textAlign = TextAlign.End
                    )
                )
            }
        }
    }
}
