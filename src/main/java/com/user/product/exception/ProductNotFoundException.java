package com.user.product.exception;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 14 Dec 2025
 * @version 1.0
 */
public class ProductNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	 public ProductNotFoundException(Long id) {
	        super("Product not found with id: " + id);
	    }

}
