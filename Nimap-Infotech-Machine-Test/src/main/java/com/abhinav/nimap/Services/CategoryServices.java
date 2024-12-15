package com.abhinav.nimap.Services;

import java.util.List;

import com.abhinav.nimap.Dto.CategoryDto;


public interface CategoryServices {
	
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//delete
	void deleteCategory( Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//getAll
    List<CategoryDto> getCategories(Integer pageNumber,Integer pageSize);


}
