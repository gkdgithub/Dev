package com.codewithgaurav.blog.service;

import java.util.List;

import com.codewithgaurav.blog.dto.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);

	List<CategoryDto> getAllCategory();

	CategoryDto getCategoryById(Integer categoryId);

	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	void deleteCategory(Integer categoryId);
}
