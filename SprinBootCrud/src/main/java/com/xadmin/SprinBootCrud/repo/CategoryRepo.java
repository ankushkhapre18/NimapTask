package com.xadmin.SprinBootCrud.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.xadmin.SprinBootCrud.model.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>, PagingAndSortingRepository<Category, Long> {

}
