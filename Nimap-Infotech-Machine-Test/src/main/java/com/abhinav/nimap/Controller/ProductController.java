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

import com.abhinav.nimap.Dto.ProductDto;
import com.abhinav.nimap.Services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	       @Autowired
	       private ProductServices productServices;
	

	   	    //Post - create user
	   	    @PostMapping("/")
	   	    public ResponseEntity<ProductDto> createproduct(@RequestBody ProductDto productDto,Integer categoryId)
	   	    {
	   	      ProductDto createUserDto = this.productServices.createProduct(productDto,categoryId);
	   		  return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	   					
	   	    }
	   	 
	   		
	   		// put - update user
	   		@PutMapping("/{productId}")
	   		public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,Integer categoryId,@PathVariable("productId")  Integer productId)
	   		{
	   			ProductDto updatedProduct = this.productServices.updateProduct(productDto, productId,categoryId);
	   		    return ResponseEntity.ok(updatedProduct);
	   		}

	   		//Delete - delete user
	   		@DeleteMapping("/{productId}")
	   		public String deleteProduct(@PathVariable("productId")Integer productId )
	   		{
	   			this.productServices.deleteProduct(productId);
	   			return "deleted";
	   		}
	   		

	   		//Get - user get	
	   		@GetMapping("/")
	   		public ResponseEntity<List<ProductDto>> getAllProduct(
	   				@RequestParam(value = "pageNumber",defaultValue = "1",required = false)Integer pageNumber,
	   				@RequestParam(value = "pageSize",defaultValue = "2",required = false) Integer pageSize
	   				)
	   		
	   		{
	   			 pageNumber = pageNumber - 1;
	   			List<ProductDto> allProduct = this.productServices.getAllProduct(pageNumber, pageSize);
	   			return new ResponseEntity<List<ProductDto>>(allProduct,HttpStatus.OK);
	   		
	   		}
	   		
	   		//get by id
	   		@GetMapping("/{productId}")
	   		public ResponseEntity<ProductDto> getSingleUser(@PathVariable Integer productId)
	   		{
	   			return ResponseEntity.ok(this.productServices.getProductById(productId));
	   		}
}
