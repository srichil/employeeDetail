package com.example.employeeDetail.Response;

import java.util.List;

public class EmployeeResponse {
	private int id;
    private String firstName;
    private String lastName;
    private double yearlySalary;
    private double tax;
    private double cess;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getCess() {
		return cess;
	}
	public void setCess(double cess) {
		this.cess = cess;
	}
	
}
