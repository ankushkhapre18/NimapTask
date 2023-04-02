package com.xadmin.SprinBootCrud.service;

import com.xadmin.SprinBootCrud.repo.ProductRepository;
import com.xadmin.SprinBootCrud.model.*;


// Importing required classes
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl  {
	@Autowired
	private ProductRepository productRepository;

	// Save operation
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	// Read operation
	
	public List<Product> fetchProductList() {
		return (List<Product>) productRepository.findAll();
	}

	// Update operation
	public Product updateProduct(Product product, Long productId) {
		Product prodDB = productRepository.findById(productId).get();

		if (Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName())) {
			prodDB.setProductName(product.getProductName());
		}


		if (Objects.nonNull(product.getProductCode()) && !"".equalsIgnoreCase(product.getProductCode())) {
			prodDB.setProductCode(product.getProductCode());
		}

		return productRepository.save(prodDB);
	}

	// Delete operation
	
	public void deleteProductById(Long productId) {
		productRepository.deleteById(productId);
	}

}
