package com.sam_chordas.android.stockhawk.ui;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.service.StockRemoteService;

/**
 * Implementation of App Widget functionality.
 */
public class StockFraudWidget extends AppWidgetProvider {

    //ArrayList<String> price = new ArrayList<>();


    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        /*price.add("1");
        price.add("1");
        price.add("1");
        price.add("1");
        price.add("1");*/
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.stock_fraud_widget);

            setRemoteAdapter(context,views);
            Intent intent = new Intent(context, StockRemoteService.class);
            //PendingIntent pendingIntent =  PendingIntent.getActivity(context, 0, intent, 0);
            context.startService(intent);


            appWidgetManager.updateAppWidget(appWidgetId, views);
        }

        //Intent intent = new Intent(context, StockRemoteService.class);

        //context.startService(intent);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    private void setRemoteAdapter(Context context, @NonNull final RemoteViews views) {
        views.setRemoteAdapter(R.id.widget_list,
                new Intent(context, StockRemoteService.class));
    }
}

