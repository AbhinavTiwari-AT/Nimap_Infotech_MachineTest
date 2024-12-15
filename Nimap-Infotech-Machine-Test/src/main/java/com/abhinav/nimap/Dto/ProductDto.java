package com.abhinav.nimap.Dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
	
    private int productId;
	
	private String  name;
	
	private float price;

	private int categoryId;

	private CategoryDto category;
	

}
