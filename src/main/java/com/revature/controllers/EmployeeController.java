package com.revature.controllers;
import java.util.List;
import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EmployeeController{
    EmployeeService es = new EmployeeService();
}
    public Handler getEmployeesHandler = (ctx) ->{
        List<Employee> allEmployees = es.getEmployees();
        Gson gson = new Gson();
        String JSONObject = gson.toJson(allEmployees);
        ctx.result(JSONObject);
        ctx.status(200);
    };

    public Handler insertEmployeesHandler = this::handle;

    private void handle(Context ctx) {
        String body = ctx.body();
        Gson gson = Gson();
        Employee employee = gson.fromJson(body, Employee.class);
        es.addEmployee(employee);
        ctx.result("Employee successfully added!");
        ctx.status(201);
    }
}
