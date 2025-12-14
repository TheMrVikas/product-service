package com.user.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.user.product.dto.ProductRequest;
import com.user.product.dto.ProductResponse;
import com.user.product.entity.ProductEntity;
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
		ProductEntity productEntity = mapper.map(request,ProductEntity.class);
		
		//2. persist entity to database
		ProductEntity productEntityReponse = repository.save(productEntity);
		
		//3.convert entity response to dto response
		return mapper.map(productEntityReponse,ProductResponse.class);
	}

	@Override
	public ProductResponse getProductById(Long id) {
		ProductEntity productEntity = repository.findById(id).orElseThrow();  //here need to through custum exception
		return mapper.map(productEntity, ProductResponse.class);
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
		//repository.find
		return null;
	}

	@Override
	public ProductResponse updateProduct(Long id, ProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}

}
