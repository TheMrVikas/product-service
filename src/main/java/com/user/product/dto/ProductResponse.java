package com.user.product.dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * Description: this class is responsible for capture request data
 * vikas
 * @created on 14 Dec 2025
 * @version 1.0
 */
@Data
public class ProductResponse {
	 private Long id;
	 private String name;
	 private String description;
	 private Double price;
	 private String category;
	 private Integer stock;
	 private Boolean active;
	 private LocalDateTime createdDate;
}
