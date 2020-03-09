package com.demo.todos.dao.common;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class AbstractDao<T , ID extends Serializable> extends SimpleJpaRepository<T, ID> implements IAbstractDao<T, ID>{

	public AbstractDao(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		// TODO Auto-generated constructor stub
	}
}
