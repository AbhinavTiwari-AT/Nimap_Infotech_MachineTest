package com.abhinav.nimap.Services;

import java.util.List;

import com.abhinav.nimap.Dto.ProductDto;

public interface ProductServices {
	
	 // create
	 ProductDto createProduct(ProductDto productDto,Integer categoryId);
	  
	 //update
	 ProductDto updateProduct(ProductDto productDto,Integer productId,Integer categoryId);
	  
	 //get by id
	 ProductDto getProductById(Integer productId);
	  
	 //get all
	 List<ProductDto> getAllProduct(Integer pageNumber,Integer pageSize);
	 
	 //delete
	 void deleteProduct(Integer productId);    

}
