package com.kodlama.io.northwind.entities;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {

	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "unitPrice")
	private double unitPrice;
	
	@Column(name="unitsInStock")
	private int unitsInStock;
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;
}
