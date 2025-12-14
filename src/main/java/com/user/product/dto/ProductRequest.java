package com.user.product.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * Description: this class is responsible for Map the data coming from user ex: postman
 * vikas
 * @created on 14 Dec 2025
 * @version 1.0
 */
@Data
public class ProductRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private Double price;
	private String category;
	private Integer stock;
	private Boolean active;
}
