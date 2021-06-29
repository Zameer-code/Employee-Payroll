package com.employeepayroll;

/**
 * ****************************************************************************************************************** 
 * Purpose: This class is implemented for listing of Service of Payroll for the Employees
 * @author ZameerAhamad Ron (zameerraone96@gmail.com)
 * @version 1.4
 * @since 28/06/2021
 * **************************************************************************************************************
 */

import java.util.List;


public class EmployeePayrollService {
	// Using of Enum Exceptions to IO services..
	 public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

	    private List<EmployeePayrollData> employeePayrollDataList;
	    private EmployeePayrollService employeePayrollService;
	    public EmployeePayrollService() {

	    }

	    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService){
	        if(ioService.equals(IOService.DB_IO))
	            this.employeePayrollDataList = new EmployeePayrollDBService().readData();

	        return this.employeePayrollDataList;
	    }

}
