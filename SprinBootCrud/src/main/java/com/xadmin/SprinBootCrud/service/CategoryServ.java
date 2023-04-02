package com.xadmin.SprinBootCrud.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xadmin.SprinBootCrud.repo.*;
import com.xadmin.SprinBootCrud.model.*;


@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo CategoryRepository;

	
	public Category saveCategory(Category category) {
		return CategoryRepository.save(category);
	}

	// Read operation
	
	public List<Category> fetchCategoryList() {
		return (List<Category>) CategoryRepository.findAll();
	}

	// Update operation
	public Category updateCategory(Category category, Long categoryId) {
		Category catDB = CategoryRepository.findById(categoryId).get();

		if (Objects.nonNull(category.getCategoryName()) && !"".equalsIgnoreCase(category.getCategoryName())) {
			catDB.setCategoryName(category.getCategoryName());
		}


		if (Objects.nonNull(category.getCategoryCode()) && !"".equalsIgnoreCase(category.getCategoryCode())) {
			catDB.setCategoryCode(category.getCategoryCode());
		}

		return CategoryRepository.save(catDB);
	}

	// Delete operation
	
	public void deleteCategoryById(Long categoryId) {
		CategoryRepository.deleteById(categoryId);
	}
	
}
