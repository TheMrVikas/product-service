package com.user.product.service;

import java.util.List;

import com.user.product.dto.ProductRequest;
import com.user.product.dto.ProductResponse;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 14 Dec 2025
 * @version 1.0
 */
public interface ProductService {
	
	/**
	 * this method is responsible for take ProductRequest as request
	 * and copy productRequestDTO data into the entity so request data 
	 * can persites into the database
	 * @param request
	 * @return
	 * TODO
	 * ProductResponse
	 */
	 ProductResponse createProduct(ProductRequest request);
	 
	 /**
	  * this method is responsible to get the product based on products id
	  * @param id
	  * @return
	  * TODO
	  * ProductResponse
	  */
	 ProductResponse getProductById(Long id);
	 
	 /**
	  * this method is responsible to get the product presents into the database
	  * @return
	  * TODO
	  * List<ProductResponse>
	  */
	 List<ProductResponse> getAllProducts();
	 
	 /**
	  * this method is responsible to get the product based on category
	  * @param category
	  * @return
	  * TODO
	  * List<ProductResponse>
	  */
	 List<ProductResponse> getByCategory(String category);
	 
	 /**
	  * this method is responsible to update the product based on product id
	  * @param id
	  * @param request
	  * @return
	  * TODO
	  * ProductResponse
	  */
	 ProductResponse updateProduct(Long id, ProductRequest request);
	 
	 /**
	  * this method is responsible to delete the product based on product id
	  * @param id
	  * TODO
	  * void
	  */
	 void deleteProduct(Long id);
}
