package com.abhinav.nimap.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.abhinav.nimap.Dto.ProductDto;
import com.abhinav.nimap.Entity.Category;
import com.abhinav.nimap.Entity.Product;
import com.abhinav.nimap.Exception.ResourceNotFoundException;
import com.abhinav.nimap.Repository.CategoryRepo;
import com.abhinav.nimap.Repository.ProductRepo;
import com.abhinav.nimap.Services.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
    // create product
	@Override
	public ProductDto createProduct(ProductDto productDto,Integer categoryId) {
		
		   Category category = categoryRepo.findById(productDto.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));
		   Product product = this.modelMapper.map(productDto, Product.class);
		   product.setName(productDto.getName());
		   product.setPrice(productDto.getPrice());
		   product.setCategory(category);
		   Product savedProduct = this.productRepo.save(product);
		   return this.modelMapper.map(savedProduct,ProductDto.class);
		 
	}

	//update product
	@Override
	public ProductDto updateProduct(ProductDto productDto, Integer productId,Integer categoryId) {

		Product product = this.productRepo.findById(productId).orElseThrow(()-> new  ResourceNotFoundException("Product","productId",productId));
		Category category = this.categoryRepo.findById(productDto.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId",categoryId));
	    product.setCategory(category);
		product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());        
        Product updatedProduct = this.productRepo.save(product);
        return this.modelMapper.map(updatedProduct,ProductDto.class);  
	}
	
    //get product by id 
	@Override
	public ProductDto getProductById(Integer productId) {
		
		 Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
		 return this.modelMapper.map(product, ProductDto.class);
	}

	//get all product
	@Override
	public List<ProductDto> getAllProduct(Integer pageNumber, Integer pageSize) {
		
		//int PageSize=5;
		//int pageNumber=1;

	    Pageable p = PageRequest.of(pageNumber, pageSize);
				
		Page<Product> pageProduct =  this.productRepo.findAll(p);
		List<Product> products = pageProduct.getContent();
				
		List<ProductDto> productDtos = products.stream().map(product ->this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
		return productDtos;
		
	}
 
	// delete product
	@Override
	public void deleteProduct(Integer productId) {
		
		Product product =	this.productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","productId",productId));
		this.productRepo.delete(product);

	}

}
