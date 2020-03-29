package com.example.demo.service;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	Iterable<Employee> findAll();

	Employee findOne(Long id);

	Employee save(Employee loaiSp);

	void delete(Long id);
}
