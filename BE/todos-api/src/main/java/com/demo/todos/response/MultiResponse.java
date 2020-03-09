package com.demo.todos.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiResponse<T> extends BaseResult{
	private List<T> data;
}
