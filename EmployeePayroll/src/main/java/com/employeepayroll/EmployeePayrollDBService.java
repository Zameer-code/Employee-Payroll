package com.employeepayroll;

/**
 * ****************************************************************************************************************** 
 * Purpose: This class is implemented for Data Base Service of Payroll for the Employees
 * @author ZameerAhamad Ron (zameerraone96@gmail.com)
 * @version 1.4
 * @since 29/06/2021
 * **************************************************************************************************************
 */

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class EmployeePayrollDBService {
	 private Connection getConnection() throws SQLException { // Connection to the Data Base to mysql and info..
	        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service1";
	        String userName = "root";
	        String password = "Zameer@123";
	        Connection connection;
	        System.out.println("Connecting to database:" + jdbcURL);
	        connection = DriverManager.getConnection(jdbcURL, userName, password);
	        System.out.println("Connection is successful!" + connection);
	        return connection;
	    }

	    public List<EmployeePayrollData> readData() { // Data Base of Employee Payroll and Getting the Results..
	        String sql = "SELECT * FROM employee_payroll; ";
	        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
	        try {
	            Connection connection = this.getConnection();
	            Statement statement = connection.createStatement();
	            ResultSet result = statement.executeQuery(sql);
	            while(result.next()){
	                int id  = result.getInt("id");
	                String name = result.getString("name");
	                double salary = result.getDouble("salary");
	                LocalDate startDate = result.getDate("start").toLocalDate();
	                employeePayrollDataList.add(new EmployeePayrollData(id, name, salary, startDate));
	            }
	            connection.close(); // Closing the Data Base Connections
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return employeePayrollDataList;
	    }

}
