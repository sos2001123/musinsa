package com.musin.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musin.domain.Category;
import com.musin.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepostitory;
	
	public Long insert(Category category) {
		categoryRepostitory.save(category);
		return category.getCategoryId();
	}
	public List<Category> findAll() {
		List<Category> category = categoryRepostitory.findAll();
		return category;
		
	}
	public void deleteById(Long categoryId) {
		categoryRepostitory.deleteById(categoryId);
	}

	public Category findByCategoryId(Long categoryId) {
		Category category = categoryRepostitory.findByCategoryId(categoryId);
		return category;
		
	}
	public List<Category> subCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		List<Category> category= categoryRepostitory.subCategoryId(categoryId);
		return category;
	}
	public List<Category> categoryDiv(int i) {
		// TODO Auto-generated method stub
		List<Category> category= categoryRepostitory.categoryDiv(i);
		return category;
	}
}
