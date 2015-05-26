package com.qq.json;

import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by qq on 15-5-14.
 */
public class JsonCommon {


    public void Decoder(AssetManager assetManager) throws IOException {

        InputStreamReader isr = new InputStreamReader(assetManager.open("order.json"), "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        StringBuffer builder = new StringBuffer();
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }

        try {
            JSONObject root = new JSONObject(builder.toString());
            root.getString("orderName");//字段
            JSONArray array = root.getJSONArray("d_list");
            for (int i = 0; i < array.length(); i++) {
                JSONObject temp = array.getJSONObject(i);
                temp.getString("name");

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public void Encoder(AssetManager assetManager) throws IOException, JSONException {

        JSONObject root = new JSONObject();
        root.put("cat", "1");

        JSONArray array = new JSONArray();
        for (int i = 0; i < 3; i++) {
            JSONObject temp = new JSONObject();
            temp.put("name", i);
            array.put(temp);
        }
        root.put("list", array);

    }
}
