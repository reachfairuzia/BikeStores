package com.tutorial.bikestores.production.product;

import com.tutorial.bikestores.production.brand.Brand;
import com.tutorial.bikestores.production.category.Category;
import com.tutorial.bikestores.production.category.CategoryRepository;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(schema = "production", name = "products")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "model_year")
    private Integer modelYear;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
