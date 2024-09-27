package com.boot.questionservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor   //with this annotation, we can have both parameterized and default constructor.
public class Response {
	
	private Integer id;
	private String response;

}
