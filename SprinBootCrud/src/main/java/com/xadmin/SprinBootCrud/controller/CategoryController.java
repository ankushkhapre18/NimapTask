package com.xadmin.SprinBootCrud.controller;


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
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SprinBootCrud.model.*;
import com.xadmin.SprinBootCrud.service.*;


@RestController
@RequestMapping("/Category")
public class CategoryController {
	
	// Annotation
		@Autowired
		private CategoryServ CS;

		// Save operation
		@PostMapping("")
		public ResponseEntity<?> save(@RequestBody Category category){
			
			ResponseEntity<?> r = new ResponseEntity<>(CS.saveCategory(category), HttpStatus.OK);
			return r;
		}

		// Read operation
		@GetMapping("")
		public ResponseEntity<?> list(){
			
			ResponseEntity<?> r = new ResponseEntity<>(CS.fetchCategoryList(), HttpStatus.OK);
			return r;
		}

		// Update operation
		@PutMapping("/{id}")
		public ResponseEntity<?>updatebyid(@RequestBody Category category, @PathVariable("id") Long ID){
			
			ResponseEntity<?> r = new ResponseEntity<>(CS.updateCategory(category, ID), HttpStatus.OK);
			return r;
		}

		// Delete operation
		@DeleteMapping("/{id}")
		public String Delete(@PathVariable("id") Long ID){
			CS.deleteCategoryById(ID);
			return	"Deleted Successfully";
		}

}
