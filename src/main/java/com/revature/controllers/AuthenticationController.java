package com.revature.controllers;
import com.google.gson.Gson;
import com.revature.models.MockLogin; //similar to LoginDTO
import com.revature.services.AuthenticationServices;
import io.javalin.http.Handler;

public class AuthenticationController {
    AuthenticationServices as = new AuthenticationServices();

    public Handler loginHandler = (ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        //I recommend you make this an employee object
        MockLogin MLogin = gson.fromJson(body, MockLogin.class);

        if(as.login(MLogin.getUsername(), MLogin.getPassword()) == 1) {
            ctx.status(201);
            ctx.result("Entrance Successful!");
        }
        else if(as.login(MLogin.getUsername(), MLogin.getPassword()) == 2) {
            ctx.status(202);
            ctx.result("Entrance Successful!");
        }
        else {
            ctx.result("Login Unsuccessful.");
            ctx.status(401);
        }
    };

}
