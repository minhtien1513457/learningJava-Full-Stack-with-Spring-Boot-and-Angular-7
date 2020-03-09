package com.demo.todos.service.implement;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.demo.todos.dao.ITodoDao;
import com.demo.todos.model.TodoEntity;
import com.demo.todos.service.TodoService;
import com.demo.todos.vo.TodoVo;

public class TodoServcieImpl implements TodoService {
	@Autowired
	ITodoDao todoDao;

	protected TodoVo populateTodo(TodoEntity obj) {
		TodoVo res = new TodoVo();
		res.setId(obj.getId());
		res.setCreatedDate(obj.getCreatedDate());
		res.setCreatedUser(obj.getCreatedUser());
		res.setDescription(obj.getDescription());
		res.setDone(obj.isDone());
		res.setTargetDay(obj.getTargetDay());
		res.setUpdatedDate(obj.getUpdatedDate());
		res.setUpdatedUser(obj.getUpdatedUser());
		return res;
	}

	@Override
	public List<TodoVo> getAll() {
		List<TodoVo> res = new LinkedList<TodoVo>();
		List<TodoEntity> todos = todoDao.findAll();
		if (!CollectionUtils.isEmpty(todos)) {
			for (TodoEntity todo : todos) {
				res.add(populateTodo(todo));
			}
		}
		return res;
	}

	@Override
	public TodoVo findOne(Long id) {
		TodoVo res = populateTodo(todoDao.findById(id).orElse(null));
		return res;
	}

	@Override
	public TodoVo save(TodoEntity obj) {
		TodoVo res = populateTodo(todoDao.save(obj));
		return res;
	}

	@Override
	public void delete(Long id) {
		todoDao.deleteById(id);
	}

}
