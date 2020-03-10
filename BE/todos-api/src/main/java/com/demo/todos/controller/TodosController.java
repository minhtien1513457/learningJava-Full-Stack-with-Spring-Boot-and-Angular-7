package com.demo.todos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.demo.todos.model.TodoEntity;
import com.demo.todos.service.TodoService;
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
    private TodoService todoService;
	
	 @GetMapping("/todos")
	    public List<TodoVo> getAllTodos() {
	        return todoService.getAll();
	    }
	 
	 @GetMapping("/todos/{id}")
	    public ResponseEntity<TodoVo> getTodoById(@PathVariable(value = "id") Long todoId){
		 TodoVo todo = todoService.findOne(todoId);
	        return ResponseEntity.ok().body(todo);
	    }
	 
	 @PostMapping("/todos")
	    public TodoVo createTodo(@Valid @RequestBody TodoEntity obj) {
	        return todoService.save(obj);
	    }

	 @PutMapping("/employees/{id}")
	    public ResponseEntity<TodoVo> updateTodo(@PathVariable(value = "id") Long todoId,
	         @Valid @RequestBody TodoEntity objDetail) {
	        final TodoVo updatedObj = todoService.save(objDetail);
	        return ResponseEntity.ok(updatedObj);
	    }
	 
	 @DeleteMapping("/employees/{id}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId){
	        employeeService.delete(employeeId);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
