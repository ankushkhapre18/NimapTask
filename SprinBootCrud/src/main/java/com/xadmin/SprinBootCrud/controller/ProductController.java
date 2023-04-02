package com.xadmin.SprinBootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SprinBootCrud.service.ProductServiceImpl;
import com.xadmin.SprinBootCrud.model.*;

@RestController
@RequestMapping("/product")
public class ProductController {

	 // Annotation
    @Autowired private ProductServiceImpl productService;
 
    // Save operation
    @PostMapping("")
    public Product saveProduct(
        @RequestBody Product product)
    {
        return productService.saveProduct(product);
    }
 
    // Read operation
    @GetMapping("")
    public List<Product> fetchProductList()
    {
        return productService.fetchProductList();
    }
 
    // Update operation
    @PutMapping("/{id}")
    public Product
    updateProduct(@RequestBody Product product,
                     @PathVariable("id") Long productId)
    {
        return productService.updateProduct(
        		product, productId);
    }
 
    // Delete operation
    @DeleteMapping("{id}")
    public String deleteProductById(@PathVariable("id")
                                       Long productId)
    {
    	productService.deleteProductById(
    			productId);
        return "Deleted Successfully";
    }
	
}
