package com.sam_chordas.android.stockhawk.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.gcm.TaskParams;
import com.sam_chordas.android.stockhawk.R;

/**
 * Created by sam_chordas on 10/1/15.
 */
public class StockIntentService extends IntentService {

  Handler mHandler;

  public StockIntentService() {
    super(StockIntentService.class.getName());
  }

  public StockIntentService(String name) {
    super(name);
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    Log.d(StockIntentService.class.getSimpleName(), "Stock Intent Service");
    StockTaskService stockTaskService = new StockTaskService(this);
    Bundle args = new Bundle();

    if (intent.getStringExtra("tag").equals("add")) {
      args.putString("symbol", intent.getStringExtra("symbol"));
    }else if (intent.getStringExtra("tag").equals("history")){
      args.putString("symbol", intent.getStringExtra("symbol"));
    }
    // We can call OnRunTask from the intent service to force it to run immediately instead of
    // scheduling a task.
    try {
      stockTaskService.onRunTask(new TaskParams(intent.getStringExtra("tag"), args));

    } catch (NumberFormatException e) {
      mHandler = new Handler(getMainLooper());
      mHandler.post(new InvalidToast(this,getString(R.string.invalid_toast)));
      Log.e("NOW YOU FUCKED UP", "IT BROKE", e);
    }
  }
}

