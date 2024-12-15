package com.abhinav.nimap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NimapInfotechMachineTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimapInfotechMachineTestApplication.class, args);
	}
	

	//Using ModelMapper
    @Bean   
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
 
}
