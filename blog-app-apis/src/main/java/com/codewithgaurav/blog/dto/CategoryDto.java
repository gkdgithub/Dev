package com.codewithgaurav.blog.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	@NotBlank
	@Size(min = 3)
	private String categoryTitle;
	@NotBlank
	@Size(min = 10)
	private String categoryDescription;
	
}
