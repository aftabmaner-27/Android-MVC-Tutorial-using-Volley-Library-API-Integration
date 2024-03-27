package com.aftabmaner_27.androidmvcproject.Models;

// Model.java
//models class can get and set properties
public class LoginModel {
    private String userName;
    private String password;

    public LoginModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

