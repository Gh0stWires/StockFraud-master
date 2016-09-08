package com.sam_chordas.android.stockhawk.service;

import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

/**
 * Created by gh0st on 8/27/16.
 */
public class StockRemoteFactory implements RemoteViewsService.RemoteViewsFactory {
    private static final String[] Stocks = {"FUCK YOU", "FUCK YOU", "FUCK YOU", "FUCK YOU", "FUCK YOU"};

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {


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
        return null;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
