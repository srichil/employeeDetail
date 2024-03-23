package com.example.employeeDetail.model;

import java.time.LocalDate;

import java.util.List;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfJoining;
    private double salary;
    private double yearlySalary;
	private List<String> phoneNumbers;
    private double tax;
    private double cess;
    
    public double getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

    public double getCess() {
		return cess;
	}

	public void setCess(double cess) {
		this.cess = cess;
	}

	public Employee(int id, String firstName, String lastName, String email, String dateOfJoining, double salary, List<String> phoneNumbers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        this.phoneNumbers = phoneNumbers;
    }

    // Getters and setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTax() {
		return tax;
	}

}
