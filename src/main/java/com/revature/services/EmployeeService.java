package com.revature.services;
import java.sql.SQLException;
import java.util.List;
import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;
public class EmployeeService {

        EmployeeDAO eDAO = new EmployeeDAO(); //to use methods from EmployeeDAO
        public List<Employee> getEmployees() throws SQLException{
            //get the List of Employees by calling the DAO method that selects them from the db
            List<Employee> employees = eDAO.getEmployees();
            //return the list of employees
            return employees;
        }
        public void addEmployee(Employee newEmployee) throws SQLException {
            //take in the Employee object sent from the menu and send it to the EmployeeDAO to be inserted into the db

            //call the DAO method that inserts the new Employee
            eDAO.insertEmployee(newEmployee);
        }
        //This is only returning one object so it doesn't necessarily have to be a list...
        public List<Employee> getEmployeeById(int id) {
            List<Employee> employee= eDAO.getEmployeeByID(id);
            return employee;
        }
        public List<Employee> getEmployeeByRoleTitle(String roleTitle){
                List<Employee> employees = eDAO.getEmployeesByRoleTitle(roleTitle);
                return employees;
        }

}
