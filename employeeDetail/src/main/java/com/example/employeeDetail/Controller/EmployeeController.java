package com.example.employeeDetail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeDetail.Response.EmployeeResponse;
import com.example.employeeDetail.Service.EmployeeService;
import com.example.employeeDetail.model.Employee;

@RestController
@RequestMapping("/employeeDemo")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    //public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        //return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        return new ResponseEntity<>("Created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("employeeId") int employeeId) {
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(employeeId);
        if (employeeResponse != null) {
            return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}