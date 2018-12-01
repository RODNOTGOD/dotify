package com.dotify.music.dotify;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RetrieveMusic extends AsyncTask<String, JSONArray, JSONArray> {

    @Override
    protected JSONArray doInBackground(String... strings) {
        String result = "";
        InputStream is = null;

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection urlConnection;
            urlConnection = (HttpURLConnection) url.openConnection();
            is = urlConnection.getInputStream();
            Log.i("log_tag", "CONNECTION FINISHED");
        } catch(Exception e){
            Log.e("log_tag", "Error in http connection "+e.toString());
        }

        //convert response to string
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"),8);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();

            result=sb.toString();
            Log.i("log_tag", "READ FINISHED");
        }catch(Exception e){
            Log.e("log_tag", "Error converting result "+e.toString());
        }

        //parse json data
        try{
            JSONArray jsonArray = new JSONArray(result);
            Log.i("log_tag", "JSON BUILD FINISHED");
            return jsonArray;
        } catch(JSONException e){
            Log.e("log_tag", "Error parsing data "+e.toString());
        }

        return null;
    }
}
