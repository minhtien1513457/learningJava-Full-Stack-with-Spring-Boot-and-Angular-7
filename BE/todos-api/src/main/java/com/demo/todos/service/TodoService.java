package com.demo.todos.service;

import java.util.List;

import com.demo.todos.model.TodoEntity;
import com.demo.todos.vo.TodoVo;

public interface TodoService {
	List<TodoVo> getAll();
	
	TodoVo findOne(Long id);
	
	TodoVo save(TodoEntity obj);
	
	void delete(Long id);
}
