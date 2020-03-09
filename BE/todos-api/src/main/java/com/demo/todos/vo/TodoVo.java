package com.demo.todos.vo;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoVo {

	private long id;
	
	private String description;
	
	private	boolean done;
	
	private LocalDateTime targetDay;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime updatedDate;
	
	private String createdUser;
	
	private String updatedUser;
}
