package com.employeepayroll;

/**
 * ****************************************************************************************************************** 
 * Purpose: This class is implemented for Demonstration of Data Base Service of Payroll for the Employees
 *  connecting to Mysql
 * @author ZameerAhamad Ron (zameerraone96@gmail.com)
 * @version 1.4
 * @since 29/06/2021
 * **************************************************************************************************************
 */


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBDemo {
	
	//Using Main String to connect to the Mysql Data Base..
	
	public static void main(String[] args) throws ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Zameer@123";
        Connection connection;

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded!");

        listDrivers();
        try{
            System.out.println("Connecting to database:" +jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful!!!!"+connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }

}
