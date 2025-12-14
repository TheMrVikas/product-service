package com.user.product.entity;

import java.io.Serializable;

import com.user.product.entity.base.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 13 Dec 2025
 * @version 1.0
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "products")
public class Product extends AuditableEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	 @SequenceGenerator(
	            name = "product_seq",
	            sequenceName = "PROD_SEQ",
	            allocationSize = 1
	    )
	@Column(name = "product_id")
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "description")
    private String description;

	@Column(name = "price")
    private Double price;

	@Column(name = "category")
    private String category;

	@Column(name = "stock")
    private Integer stock;     // Optional: You may keep stock in Inventory MS

	@Column(name = "product_active")
    private Boolean active;
}
