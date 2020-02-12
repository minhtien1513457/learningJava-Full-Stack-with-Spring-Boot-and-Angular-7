package com.demo.todos.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Data
@Table(name = "plan")
public class todoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String description;
	
	@Column 
	private	boolean done;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date targetDay;
	
	@Column (nullable = false, updatable= false, name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;
	
	@Column (nullable = false, name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedDate;
	
	@Column (name = "created_user")
	@CreatedBy
	private String createdUser;
	
	@Column (name = "updated_user")
	@LastModifiedBy
	private String updatedUser;
	
}
