package com.abhinav.nimap.Dto;

import com.abhinav.nimap.Entity.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
	
    private int productId;
	
	private String  productName;
	
	private float price;
	
	//private int categoryId;

}
