package com.revature;
import java.sql.Connection;
import java.sql.SQLException;
import com.revature.controllers.AuthenticationController;
import com.revature.controllers.EmployeeController;
import com.revature.utilities.ConnectionFactory;
import io.javalin.Javalin;

public class Launcher {
    public static void main(String[] args) {
        EmployeeController ec = new EmployeeController();
        AuthenticationController ac = new AuthenticationController();
        //Testing Database Connectivity - just testing whether our Connection
        try(Connection conn = ConnectionFactory.getConnection()){
            System.out.println("Connection Successful yay!");

        } catch(SQLException e) {
                System.out.println("Connection failed");
                e.printStackTrace();
        }

        //Javalin starts (which creates the connection, done
        Javalin app = Javalin.create(
                config -> {
                        config.enableCorsForAllOrigins(); //
                }
        ).start(3000);
        //Now we need our endpoints
        //this is where we talk to the HTMLs
        app.get("/employee", ecgetEmployeesHandler);
        app.post("/employee", ec.insertEmployeesHandler);
        //In the future, we will also add a log in function
        app.post("/login", ac.loginHandler);
    }
}