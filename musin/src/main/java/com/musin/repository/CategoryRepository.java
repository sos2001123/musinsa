package com.musin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musin.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByCategoryId(Long categoryId);

	List<Category> subCategoryId(Long categoryId);

	List<Category> categoryDiv(int i);
	
}
