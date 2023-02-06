package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
//	SELECT * FROM tb_product
//	  INNER JOIN tb_product_category ON tb_product.id = tb_product_category.product_id 
//    INNER JOIN tb_category ON tb_category.id = tb_product_category.category_id
	
//	SELECT * FROM tb_product
//	  INNER JOIN tb_product_category ON tb_product.id = tb_product_category.product_id 
//    INNER JOIN tb_category ON tb_category.id = tb_product_category.category_id
//    WHERE tb_product.id IN (1,2,3,4,5)

	
	// JOIN FETCH
	@Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :products")
	List<Product> findProductsCategories(List<Product> products);
	
}
