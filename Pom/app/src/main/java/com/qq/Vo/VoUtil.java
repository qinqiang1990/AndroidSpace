package com.qq.Vo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by qinqiang on 2015/5/17.
 */
public class VoUtil {
    public void GetJson(String JSONDataURL, Activity activity) {

        RequestQueue mQueue = Volley.newRequestQueue(activity);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                JSONDataURL,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.d("JSON_SUCCESS", jsonObject.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("JSON_ERROR", error.toString());
                    }
                }
        );

        mQueue.add(jsonObjectRequest);

    }

    public void GetImage(String imageURL, Activity activity, int id, int default_image, int error_image) {
        ImageView imageView = (ImageView) activity.findViewById(id);
        RequestQueue mQueue = Volley.newRequestQueue(activity);
        final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(20);
        ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String key) {
                return lruCache.get(key);
            }

            @Override
            public void putBitmap(String key, Bitmap value) {
                lruCache.put(key, value);
            }
        };
        ImageLoader imageLoader = new ImageLoader(mQueue, imageCache);
        imageView.setTag(imageURL);
        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView, default_image, error_image);
        imageLoader.get(imageURL, imageListener);
    }


    public void GetNetworkImage(String imageURL, Activity activity, int id) {
        NetworkImageView networkImageView = (NetworkImageView) activity.findViewById(id);
        RequestQueue mQueue = Volley.newRequestQueue(activity);
        final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(20);
        ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String key) {
                return lruCache.get(key);
            }

            @Override
            public void putBitmap(String key, Bitmap value) {
                lruCache.put(key, value);
            }
        };
        ImageLoader imageLoader = new ImageLoader(mQueue, imageCache);
        networkImageView.setTag(imageURL);
        networkImageView.setImageUrl(imageURL, imageLoader);

    }
}
