package com.example.bala.servicecallsbasics;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class ServiceClass {
    interface CustomParse{
        public void doCustomParsing(String response);
    }
    private static String TAG = "ServiceClass";

    public static void makeRequest(Context context, String url,final CustomParse customParse) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        final ArrayList<BasicModel> basicModels = new ArrayList<>();
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        customParse.doCustomParsing(response);
                        // Display the first 500 characters of the response string.
                        Log.d(TAG, "onResponse: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public static void setImageToImageView(Context context, String url, final ImageView imageView) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
// Request a string response from the provided URL.
        ImageRequest stringRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
