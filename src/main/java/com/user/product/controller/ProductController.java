package com.user.product.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.product.dto.ProductRequest;
import com.user.product.dto.ProductResponse;
import com.user.product.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * Description: this class is responsible for capture and process the request
 * vikas
 * @created on 23 Nov 2025
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService service;
	
	@GetMapping(value = { "/welcome/{name}" })
	public ResponseEntity<String> getWelcomeMsg(@PathVariable("name") String name) {
		return ResponseEntity.ok("Hello Mr. " + name);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
		ProductResponse product = service.createProduct(request);
		return Objects.nonNull(product) ? ResponseEntity.ok(product) : ResponseEntity.internalServerError().build();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductResponse>> getAll() {
		List<ProductResponse> allProducts = service.getAllProducts();
		return Objects.nonNull(allProducts) ? ResponseEntity.ok(allProducts) : ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponse> getByID(@PathVariable("id") Long id) {
		ProductResponse productById = service.getProductById(id);
		return Objects.nonNull(productById) ? ResponseEntity.ok(productById) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
		service.deleteProduct(id);
		return ResponseEntity.ok(id+" Record Deleted"); 
	}
	
	@PutMapping(value = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> update(@PathVariable("id") Long id,@RequestBody ProductRequest request) {
         ProductResponse updateProduct = service.updateProduct(id, request);
         return Objects.nonNull(updateProduct) ? ResponseEntity.ok(updateProduct) : ResponseEntity.internalServerError().build();
    }
}
