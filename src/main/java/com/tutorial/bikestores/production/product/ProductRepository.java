package com.tutorial.bikestores.production.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("""
            SELECT new com.tutorial.bikestores.production.product.ProductDTO(p.id, p.name,
            p.modelYear, p.listPrice, p.brand.name, p.category.name)
            FROM Product p
            WHERE p.name LIKE %:name%
            """)
    Page<ProductDTO> findAll(@Param("name") String name, Pageable pageable);
}
