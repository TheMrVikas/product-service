package com.user.product.controller;


import java.util.List;
import java.util.Objects;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.product.dto.ProductRequest;
import com.user.product.dto.ProductResponse;
import com.user.product.service.ProductService;

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
	
	@GetMapping(value = {"/welcome/{name}"})
	public ResponseEntity<String> getWelcomeMsg(@PathVariable("name") String name){
		return ResponseEntity.ok("Hello Mr. "+name);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductResponse>> getAll() {
    List<ProductResponse> allProducts = service.getAllProducts();
        return Objects.nonNull(allProducts)?ResponseEntity.ok(allProducts)
				:ResponseEntity.noContent().build();
    }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request){
		ProductResponse product = service.createProduct(request);
		return Objects.nonNull(product)?ResponseEntity.ok(product)
										:ResponseEntity.internalServerError().build();
	}

}
