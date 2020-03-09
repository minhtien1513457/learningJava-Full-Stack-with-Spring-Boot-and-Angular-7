package com.demo.todos.dao.common;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAbstractDao<T , ID extends Serializable>  extends JpaRepository<T, ID>{

}
