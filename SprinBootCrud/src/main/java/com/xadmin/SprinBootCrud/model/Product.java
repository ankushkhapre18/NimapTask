package com.xadmin.SprinBootCrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity(name="Product")
@Data
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ProductId;
    private String ProductName;
    private String ProductCode;
    
    @OneToOne
    @JoinColumn
    private Category category;

}
