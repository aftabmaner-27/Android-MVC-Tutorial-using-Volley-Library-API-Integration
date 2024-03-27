package com.aftabmaner_27.androidmvcproject.Controllers;

import android.content.Context;

import com.aftabmaner_27.androidmvcproject.Models.LoginModel;


// Controller.java
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginController {
    private static final String API_URL = "https://dummyjson.com/auth/login"; //enter your login api here

    private Context context;
    private RequestQueue requestQueue;

    public LoginController(Context context) {
        this.context = context;
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public void loginUser(LoginModel model, final LoginCallback callback) {
        JSONObject requestBody = new JSONObject();
        try {
            requestBody.put("username", model.getUserName());
            requestBody.put("password", model.getPassword());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, API_URL, requestBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle successful response
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error response
                        callback.onError(error.toString());
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    // Callback interface for handling login responses
    public interface LoginCallback {
        void onSuccess(JSONObject response);

        void onError(String error);
    }
}
