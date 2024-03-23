package com.example.employeeDetail.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeeDetail.Response.EmployeeResponse;
import com.example.employeeDetail.model.Employee;

@Service
public class EmployeeService {

    private final List<Employee> employeeDatabase;

    public EmployeeService() {
        this.employeeDatabase = new ArrayList<>();
    }

    public Employee createEmployee(Employee employee) {
        
        int newEmployeeId = employeeDatabase.size() + 1;
        employee.setId(newEmployeeId);
     
        double totalSalary = calculateTotalSalary(employee);
        double tax = calculateTax(totalSalary);
        double cess = calculateCess(totalSalary);    
        employee.setYearlySalary(totalSalary);
        employee.setTax(tax);      
        employeeDatabase.add(employee);
        employee.setCess(cess);
        return employee;
    }

    public EmployeeResponse getEmployeeById(int employeeId) {
    	EmployeeResponse employeeResponse = new EmployeeResponse();
        for (Employee employee : employeeDatabase) {
            if (employee.getId() == employeeId) {
            	employeeResponse.setId(employee.getId());
            	employeeResponse.setFirstName(employee.getFirstName());
            	employeeResponse.setLastName(employee.getLastName());
            	employeeResponse.setYearlySalary(employee.getYearlySalary());
            	employeeResponse.setCess(employee.getCess());
            	employeeResponse.setTax(employee.getTax());
                return employeeResponse;
            }
        }
        return null; 
    }
    private double calculateTotalSalary(Employee employee) {
       
        LocalDate dateOfJoining = LocalDate.parse(employee.getDateOfJoining());
        System.out.println("dateOfJoining : "+ dateOfJoining);
        LocalDate currentDate = LocalDate.now();
        //long monthsWorked = ChronoUnit.MONTHS.between(dateOfJoining.withDayOfMonth(1), currentDate) + 1;
        long monthsWorked = ChronoUnit.MONTHS.between(dateOfJoining, currentDate.plusDays(8));
        System.out.println("monthsWorked : "+ monthsWorked);

        
        double salaryPerMonth = employee.getSalary();
        System.out.println("Salary per amount : "+ salaryPerMonth);
        double totalSalary = salaryPerMonth * monthsWorked;
        System.out.println("total salary amount : "+ totalSalary);

        return totalSalary;
    }

    private double calculateTax(double totalSalary) {
        double tax = 0.0;

        if (totalSalary <= 250000) {           
            tax = 0.0;
        } else if (totalSalary <= 500000) {        
            tax = (totalSalary - 250000) * 0.05;
            System.out.println("Tax amount : "+ tax);
        } else if (totalSalary <= 1000000) {          
            tax = (250000 * 0.05) + ((totalSalary - 500000) * 0.10);
            System.out.println("Tax amount : "+ tax);
        } else {           
            tax = (250000 * 0.05) + (500000 * 0.10) + ((totalSalary - 1000000) * 0.20);
            System.out.println("Tax amount : "+ tax);
        }

        return tax;
    }
    private double calculateCess(double totalSalary) {
        double cess = 0.0;
        if (totalSalary > 2500000) {
            cess += (totalSalary - 2500000) * 0.02;
        }
        System.out.println("cess amount : "+ cess);
        return cess;
    }
}