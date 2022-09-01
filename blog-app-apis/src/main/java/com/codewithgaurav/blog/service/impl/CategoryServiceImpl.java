package com.codewithgaurav.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithgaurav.blog.dto.CategoryDto;
import com.codewithgaurav.blog.entities.Category;
import com.codewithgaurav.blog.exceptions.ResourceNotFoundException;
import com.codewithgaurav.blog.mapper.CategoryMapper;
import com.codewithgaurav.blog.repository.CategoryRepo;
import com.codewithgaurav.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category savedCategory = this.categoryRepo.save(this.categoryMapper.dtoToCategory(categoryDto));
		return this.categoryMapper.categoryToDto(savedCategory);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = this.categoryRepo.findAll();
		return categories.stream().map(category -> this.categoryMapper.categoryToDto(category))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = getCategoryBasedOnId(categoryId);
		return this.categoryMapper.categoryToDto(category);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = getCategoryBasedOnId(categoryId);
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCategory = this.categoryRepo.save(category);
		return this.categoryMapper.categoryToDto(updatedCategory);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = getCategoryBasedOnId(categoryId);
		this.categoryRepo.delete(category);
	}

	/**
	 * @param categoryId
	 * @return
	 */
	private Category getCategoryBasedOnId(Integer categoryId) {
		return this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found with this Id : " + categoryId));
	}

}
