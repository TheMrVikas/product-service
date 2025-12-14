package com.user.product.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.user.product.dto.ProductRequest;
import com.user.product.dto.ProductResponse;
import com.user.product.entity.Product;
import com.user.product.repository.ProductRepository;
import com.user.product.service.ProductService;

import lombok.RequiredArgsConstructor;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 14 Dec 2025
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository repository;
	private final ModelMapper mapper;

	@Override
	public ProductResponse createProduct(ProductRequest request) {
		//1. convert request to entity data
		Product productEntity = mapper.map(request,Product.class);
		
		//2. persist entity to database
		Product productEntityReponse = repository.save(productEntity);
		
		//3.convert entity response to dto response
		return mapper.map(productEntityReponse,ProductResponse.class);
	}

	@Override
	public ProductResponse getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductResponse> getAllProducts() {
		return repository
				.findAll()
				.stream()
				.map(eachProduct->mapper.map(eachProduct, ProductResponse.class))
				.toList();
	}

	@Override
	public List<ProductResponse> getByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductResponse updateProduct(Long id, ProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
	}

}
