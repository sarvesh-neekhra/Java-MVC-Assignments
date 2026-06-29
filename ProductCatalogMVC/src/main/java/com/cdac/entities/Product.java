package com.cdac.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {
	
	private long productId;
	private String productName;
	private double price;
	private int stock;
	private long categoryId;
	
}

