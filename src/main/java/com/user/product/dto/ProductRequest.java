package com.user.product.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

	@NotBlank(message = "Product name is mandatory")
	private String name;
	private String description;
	
	@NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
	private Double price;
	
	@NotBlank(message = "Category is required")
	private String category;
	private Integer stock;
	private Boolean active;
}
