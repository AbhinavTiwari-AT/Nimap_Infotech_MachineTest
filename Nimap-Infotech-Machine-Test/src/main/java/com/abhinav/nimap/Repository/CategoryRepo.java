package com.abhinav.nimap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhinav.nimap.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
