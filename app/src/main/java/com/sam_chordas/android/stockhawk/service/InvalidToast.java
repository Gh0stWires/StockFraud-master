package com.sam_chordas.android.stockhawk.service;

import android.content.Context;
import android.widget.Toast;

public class InvalidToast implements Runnable {

    private final Context mContext;
    String mMessage;

    public InvalidToast(Context mContext, String message) {
        this.mContext = mContext;
        this.mMessage = message;
    }


    @Override
    public void run() {
        Toast.makeText(mContext,mMessage,Toast.LENGTH_LONG).show();

    }
}
