package com.abhinav.nimap.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.abhinav.nimap.Dto.CategoryDto;
import com.abhinav.nimap.Entity.Category;
import com.abhinav.nimap.Exception.ResourceNotFoundException;
import com.abhinav.nimap.Repository.CategoryRepo;
import com.abhinav.nimap.Services.CategoryServices;

@Service
public class CategoryServiceImpl implements CategoryServices {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CategoryRepo categoryRepo;
	
	// create Category
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) 
	{

		Category category = this.modelMapper.map(categoryDto,Category.class);
		Category added = this.categoryRepo.save(category);
		return this.modelMapper.map(added, CategoryDto.class);
		
	}
    
	// update Category
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		 Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));
		 category.setCategoryType(categoryDto.getCategoryType());			
		 Category updateCate = this.categoryRepo.save(category);
		 return this.modelMapper.map(updateCate,CategoryDto.class);
		
	}

	// delete Category
	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));
	    this.categoryRepo.delete(category);
		
	}
    
	// Get Category
	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));
		return this.modelMapper.map(category,CategoryDto.class);
	}

	// get all Category
	@Override
	public List<CategoryDto> getCategories(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber, pageSize);

		Page<Category> pagecategory  = this.categoryRepo.findAll(p);
		List<Category> findall = pagecategory.getContent();
	    List<CategoryDto> categoriesDto = findall.stream().map((category)->this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
			
		return categoriesDto;
	}

}
