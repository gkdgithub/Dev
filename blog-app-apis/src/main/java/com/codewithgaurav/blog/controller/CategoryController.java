package com.codewithgaurav.blog.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithgaurav.blog.dto.CategoryDto;
import com.codewithgaurav.blog.response.ApiResponse;
import com.codewithgaurav.blog.service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		return new ResponseEntity<CategoryDto>(this.categoryService.createCategory(categoryDto), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		return new ResponseEntity<List<CategoryDto>>(this.categoryService.getAllCategory(), HttpStatus.OK);
	}

	@GetMapping(value = "/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(value = "categoryId") Integer categoryId) {
		return new ResponseEntity<CategoryDto>(this.categoryService.getCategoryById(categoryId), HttpStatus.OK);
	}

	@PutMapping(value = "/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable(value = "categoryId") Integer categoryId) {
		return ResponseEntity.ok(this.categoryService.updateCategory(categoryDto, categoryId));
	}

	@DeleteMapping(value = "/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable(value = "categoryId") Integer categoryId) {
		this.categoryService.deleteCategory(categoryId);
		return ResponseEntity.ok(new ApiResponse("Category Deleted Successfully", true, String.valueOf(HttpStatus.OK),
				String.valueOf(LocalDateTime.now())));
	}

}
