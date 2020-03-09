package com.demo.todos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.todos.dao.ITodoDao;
import com.demo.todos.vo.TodoVo;


@RestController
@RequestMapping(value = "/api")
public class TodosController {
	@Autowired
    private ITodoDao todoDao;
	
	 @GetMapping("/todos")
	    public List<TodoVo> getAllTodos() {
	        return todoDao.findAll();
	    }
	 
	 @GetMapping("/employees/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer employeeId){
	        Employee employee = employeeService.findOne(employeeId);
	        return ResponseEntity.ok().body(employee);
	    }
	 
	 @PostMapping("/employees")
	    public Employee createEmployee(@Valid @RequestBody Employee employee) {
	        return employeeService.save(employee);
	    }

	 @PutMapping("/employees/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
	         @Valid @RequestBody Employee employeeDetails) {
	        Employee employee = employeeService.findOne(employeeId);

	        employee.setEmailId(employeeDetails.getEmailId());
	        employee.setLastName(employeeDetails.getLastName());
	        employee.setFirstName(employeeDetails.getFirstName());
	        
	        final Employee updatedEmployee = employeeService.save(employee);
	        return ResponseEntity.ok(updatedEmployee);
	    }
	 
	 @DeleteMapping("/employees/{id}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId){
	        employeeService.delete(employeeId);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
