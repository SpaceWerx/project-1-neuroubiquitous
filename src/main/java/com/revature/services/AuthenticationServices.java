package com.revature.services;

public class AuthenticationServices {
    public int login(String username, String password){
        if(username.equals("manager") && password.equals("password")){
                return 1;
        }
        else if(username.equals("employee" && password.equals("password")){
                return 2;
       } else {            return 0;
        }
    }
}


