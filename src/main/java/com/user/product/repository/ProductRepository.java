package com.user.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.product.entity.ProductEntity;


/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 14 Dec 2025
 * @version 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByCategory(String category);
	
	List<ProductEntity> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String name,String catrgory);
}
