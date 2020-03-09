package com.demo.todos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class BaseResult {

	private String message;
	
	private Integer code = null;
	
	private boolean success = false; 

}
