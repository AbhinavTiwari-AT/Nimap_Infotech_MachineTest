package com.abhinav.nimap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhinav.nimap.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>
{
    
}
