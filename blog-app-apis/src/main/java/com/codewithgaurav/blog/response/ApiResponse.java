package com.codewithgaurav.blog.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {

	private String message;
	private Boolean success;
	private String status;
	private String timeStamp;

}