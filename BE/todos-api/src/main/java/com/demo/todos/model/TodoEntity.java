package com.demo.todos.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "plan")
public class TodoEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3601811377190024276L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "description")
	private String description;
	
	@Column (name = "done")
	private	boolean done;
	
	@Column
	private LocalDateTime targetDay;
	
	@Column (nullable = false, updatable= false, name = "created_date")
	@CreatedDate
	private LocalDateTime createdDate;
	
	@Column (nullable = false, name = "updated_date")
	@LastModifiedDate
	private LocalDateTime updatedDate;
	
	@Column (name = "created_user")
	@CreatedBy
	private String createdUser;
	
	@Column (name = "updated_user")
	@LastModifiedBy
	private String updatedUser;
	
}
