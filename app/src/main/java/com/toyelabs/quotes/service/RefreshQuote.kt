package com.toyelabs.quotes.service

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import com.toyelabs.quotes.ui.widgets.QuotesWidget

class RefreshQuote : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        QuotesWidget().update(context, glanceId)
    }
}