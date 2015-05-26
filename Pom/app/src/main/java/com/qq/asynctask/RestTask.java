package com.qq.asynctask;


import android.os.AsyncTask;
import android.widget.TextView;

import com.qq.rest.HttpRestful;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by qq on 15-5-15.
 */
public class RestTask extends AsyncTask<String, String, String> {


    private TextView textView;

    public RestTask(TextView textView) {
        this.textView = textView;
    }


    @Override
    protected String doInBackground(String... strings) {

        return HttpRestful.getString(strings[0]);
    }

    @Override
    protected void onPostExecute(String rest) {
        //解析json
        try {
            JSONObject root = new JSONObject(rest);
            textView.setText(root.get("restName").toString() + "  " + root.get("userid").toString() + "\n");
            JSONArray array = root.getJSONArray("d_list");
            for (int i = 0; i < array.length(); i++) {
                JSONObject temp = array.getJSONObject(i);
                textView.setText(textView.getText()+temp.get("name").toString() + "  " + temp.get("price").toString() + "\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}