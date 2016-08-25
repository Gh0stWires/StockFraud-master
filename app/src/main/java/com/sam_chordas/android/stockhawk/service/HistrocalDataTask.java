/*
package com.sam_chordas.android.stockhawk.service;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import com.db.chart.view.LineChartView;
import com.sam_chordas.android.stockhawk.rest.Utils;
import com.sam_chordas.android.stockhawk.ui.DetailActivity;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

*/
/**
 * Created by gh0st on 8/17/16.
 *//*

public class HistrocalDataTask extends AsyncTask<String,Void,Void>{

    private OkHttpClient client = new OkHttpClient();
    ArrayList<String>  closeNums = new ArrayList<>();
    ArrayList<String> dateNums = new ArrayList<>();
    private Context mContext;
    private Calendar calendar = Calendar.getInstance();
    private DetailActivity activity;

    public HistrocalDataTask(Context context, DetailActivity activity){
        this.mContext = context;
        this.activity = activity;
    }

    public String getDate(Calendar cal, int val){
        cal.add(Calendar.MONTH, val);
        Date dateOne = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateOutput = format.format(dateOne);
        return dateOutput;
    }

    String fetchData(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Override
    protected Void doInBackground(String... json) {
        JSONObject jsonObject = null;
        JSONArray resultsArray = null;


        String startDate = getDate(calendar, 0);
        String endDate = getDate(calendar, -1);

        StringBuilder urlStringBuilder = new StringBuilder();

        urlStringBuilder.append("https://query.yahooapis.com/v1/public/yql?q=");
        try {
            urlStringBuilder.append(URLEncoder.encode("select * from yahoo.finance.historicaldata where symbol = ", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String stockInput = json[0];

        try {
            urlStringBuilder.append(URLEncoder.encode("\"" + stockInput + "\"" + " and startDate = " + "\"" + endDate + "\"" + " and endDate = " + "\"" + startDate + "\"", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        urlStringBuilder.append("&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables."
                + "org%2Falltableswithkeys&callback=");

        String urlString;
        String getResponse;

        if (urlStringBuilder != null) {
            urlString = urlStringBuilder.toString();
            try {
                getResponse = fetchData(urlString);

                try {
                    jsonObject = new JSONObject(getResponse);

                    if (jsonObject != null && jsonObject.length() != 0) {
                        jsonObject = jsonObject.getJSONObject("query");
                        int count = Integer.parseInt(jsonObject.getString("count"));
                        if (count == 1) {
                            jsonObject = jsonObject.getJSONObject("results")
                                    .getJSONObject("quote");

                        } else {
                            resultsArray = jsonObject.getJSONObject("results").getJSONArray("quote");

                            if (resultsArray != null && resultsArray.length() != 0) {
                                for (int i = 0; i < resultsArray.length(); i++) {
                                    jsonObject = resultsArray.getJSONObject(i);
                                    closeNums.add(Utils.truncateBidPrice(jsonObject.getString("Close")));
                                    dateNums.add(jsonObject.getString("Date"));

                                }
                            }
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }
    @Override
    protected void onPostExecute (Void aVoid) {
        super.onPostExecute(aVoid);
        System.out.println(closeNums);
        LineChartView chartView = (LineChartView)mContext.

    }
}
*/
