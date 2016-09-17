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
            ArrayList<String> bumble = new ArrayList<>();

            //Cursor stocks = bumble;
            @Override
            public void onCreate() {
                bumble.add("FUCK");
                bumble.add("You");
                bumble.add("FUCK");
                bumble.add("You");
                bumble.add("FUCK");
                bumble.add("You");

            }

            @Override
            public void onDataSetChanged() {


            }

            @Override
            public void onDestroy() {

            }

            @Override
            public int getCount() {
                return bumble.size();
            }

            @Override
            public RemoteViews getViewAt(int position) {

                RemoteViews views = new RemoteViews(getPackageName(),R.layout.list_item_quote);

                views.setTextViewText(R.id.stock_symbol, bumble.get(position));


                return views;
            }

            @Override
            public RemoteViews getLoadingView() {
                return null;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }
        };
    }


}
