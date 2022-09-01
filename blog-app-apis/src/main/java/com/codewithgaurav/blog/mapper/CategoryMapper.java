package com.codewithgaurav.blog.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codewithgaurav.blog.dto.CategoryDto;
import com.codewithgaurav.blog.entities.Category;

@Component
public class CategoryMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Category dtoToCategory(CategoryDto categoryDto) {
		return this.modelMapper.map(categoryDto, Category.class);
	}

	public CategoryDto categoryToDto(Category category) {
		return this.modelMapper.map(category, CategoryDto.class);
	}

}
