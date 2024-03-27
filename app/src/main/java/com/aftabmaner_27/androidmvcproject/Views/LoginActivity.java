package com.aftabmaner_27.androidmvcproject.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

// LoginActivity.java


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aftabmaner_27.androidmvcproject.Controllers.LoginController;
import com.aftabmaner_27.androidmvcproject.Models.LoginModel;
import com.aftabmaner_27.androidmvcproject.R;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private LoginController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        controller = new LoginController(this);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validate input if needed

                LoginModel model = new LoginModel(username, password);
//                controller.loginUser(model);
                controller.loginUser(model, new LoginController.LoginCallback() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        // Handle successful login response

                        try {
//                            JSONObject mUserId = response.getJSONObject("id");
                            String mUserName = response.get("username").toString();
                            String mEmail = response.get("email").toString();
                            String mFirstName = response.get("firstName").toString();
                            String mLastName = response.get("lastName").toString();
                            String mGender = response.get("gender").toString();
                            String mImage = response.get("image").toString();
                            String mToken = response.get("token").toString();


                            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LoginActivity.this,DashBoardActivity.class);
                            startActivity(i);
                            finish();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, ""+e, Toast.LENGTH_SHORT).show();
                        }
                        
                    }

                    @Override
                    public void onError(String error) {
                        // Handle error response
                        Toast.makeText(LoginActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
