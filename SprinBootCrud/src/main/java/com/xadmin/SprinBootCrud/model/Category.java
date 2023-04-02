package com.xadmin.SprinBootCrud.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity(name="Category")
@Data
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CategoryId;
    private String CategoryName;
    
    private String CategoryCode;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Product> products;
    
	

}
