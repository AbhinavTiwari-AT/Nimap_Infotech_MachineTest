package com.abhinav.nimap.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav.nimap.Dto.CategoryDto;
import com.abhinav.nimap.Services.CategoryServices;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryServices categoryServices;
	
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto>createCategory(@RequestBody CategoryDto categoryDto)
	{
	  CategoryDto create =this.categoryServices.createCategory(categoryDto);
	  return new ResponseEntity<CategoryDto>(create,HttpStatus.CREATED);

	}
	
	   //Update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId)
	{
		
	 CategoryDto updated =this.categoryServices.updateCategory(categoryDto,categoryId);
	 return new ResponseEntity<CategoryDto>(updated,HttpStatus.OK);
	 
	}
	

	// delete
	@DeleteMapping("/{categoryId}")
	public String deleteCategory(@PathVariable Integer categoryId)
	{
	  this.categoryServices.deleteCategory(categoryId); 
	  return "deleted";
	}

	
	
	
	// get 
	@GetMapping("/{categoryId}")
	public  ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId)
	{
	   CategoryDto get = this.categoryServices.getCategory(categoryId);
	   return new ResponseEntity<CategoryDto>(get,HttpStatus.OK);
		            
	}

	// get all
	@GetMapping("")
	public ResponseEntity<List<CategoryDto>> getCategories(
			@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "2",required = false) Integer pageSize
			)
	{
	  pageNumber = pageNumber - 1;
	  List<CategoryDto> getAll = this.categoryServices.getCategories(pageNumber,pageSize);
      return ResponseEntity.ok(getAll);
      
	}


}
