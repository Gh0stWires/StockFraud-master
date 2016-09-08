package com.sam_chordas.android.stockhawk.service;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.sam_chordas.android.stockhawk.R;

import java.util.ArrayList;

/**
 * Created by gh0st on 8/27/16.
 */
public class StockRemoteService extends RemoteViewsService {


    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        int appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);


        return new RemoteViewsFactory() {
            final ArrayList<String> stocks = new ArrayList<String>();
            @Override
            public void onCreate() {

            }

            @Override
            public void onDataSetChanged() {
                stocks.add("FUCK");
                stocks.add("You");
                stocks.add("FUCK");
                stocks.add("You");
                stocks.add("FUCK");
                stocks.add("You");

            }

            @Override
            public void onDestroy() {

            }

            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public RemoteViews getViewAt(int position) {
                RemoteViews views = new RemoteViews(getPackageName(),R.layout.list_item_quote);

                views.setTextViewText(R.id.stock_symbol, (CharSequence) stocks);

                return views;
            }

            @Override
            public RemoteViews getLoadingView() {
                return new RemoteViews(getPackageName(), R.layout.list_item_quote);
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }
        };
    }


}
