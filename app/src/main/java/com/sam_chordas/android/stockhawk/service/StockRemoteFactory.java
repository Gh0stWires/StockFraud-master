package com.sam_chordas.android.stockhawk.service;

import android.content.Context;
import android.database.Cursor;
import android.os.Binder;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.data.QuoteColumns;
import com.sam_chordas.android.stockhawk.data.QuoteProvider;

/**
 * Created by gh0st on 8/27/16.
 */
public class StockRemoteFactory implements RemoteViewsService.RemoteViewsFactory {
    //private static final String[] Stocks = {"FUCK YOU", "FUCK YOU", "FUCK YOU", "FUCK YOU", "FUCK YOU"};
    Context mContext;
    Cursor mCursor = null;

    public StockRemoteFactory(Context context){
        mContext = context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {
        if (mCursor != null) {
            mCursor.close();
        }
        final long identityToken = Binder.clearCallingIdentity();
        mCursor = mContext.getContentResolver().query(QuoteProvider.Quotes.CONTENT_URI,
                new String[]{QuoteColumns._ID, QuoteColumns.SYMBOL, QuoteColumns.BIDPRICE,
                        QuoteColumns.PERCENT_CHANGE, QuoteColumns.CHANGE, QuoteColumns.ISUP},
                QuoteColumns.ISCURRENT + " = ?",
                new String[]{"1"},
                null);
        Binder.restoreCallingIdentity(identityToken);
    }

    @Override
    public void onDestroy() {
        if (mCursor != null){
            mCursor.close();
        }
    }

    @Override
    public int getCount() {
        return mCursor.getCount();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.list_item_quote);

        if (mCursor.moveToPosition(position)){
            views.setTextViewText(R.id.stock_symbol, mCursor.getString(mCursor.getColumnIndex(QuoteColumns.SYMBOL)));
            views.setTextViewText(R.id.bid_price, mCursor.getString(mCursor.getColumnIndex(QuoteColumns.BIDPRICE)));
            views.setTextViewText(R.id.change, mCursor.getString(mCursor.getColumnIndex(QuoteColumns.CHANGE)));
        }
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
}
