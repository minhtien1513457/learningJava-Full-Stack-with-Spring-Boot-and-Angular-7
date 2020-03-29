package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")	
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;
	
	 @GetMapping("/employees")
	    public List<Employee> getAllEmployees() {
	        return (List<Employee>) employeeService.findAll();
	    }
	 
	 @GetMapping("/employees/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId){
	        Employee employee = employeeService.findOne(employeeId);
	        return ResponseEntity.ok().body(employee);
	    }
	 
	 @PostMapping("/employees")
	    public Employee createEmployee(@Valid @RequestBody Employee employee) {
	        return employeeService.save(employee);
	    }

	 @PutMapping("/employees/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
	         @Valid @RequestBody Employee employeeDetails) {
	        Employee employee = employeeService.findOne(employeeId);

	        employee.setEmailId(employeeDetails.getEmailId());
	        employee.setLastName(employeeDetails.getLastName());
	        employee.setFirstName(employeeDetails.getFirstName());
	        
	        final Employee updatedEmployee = employeeService.save(employee);
	        return ResponseEntity.ok(updatedEmployee);
	    }
	 
	 @DeleteMapping("/employees/{id}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId){
	        employeeService.delete(employeeId);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
