package com.user.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.product.entity.Product;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 14 Dec 2025
 * @version 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
