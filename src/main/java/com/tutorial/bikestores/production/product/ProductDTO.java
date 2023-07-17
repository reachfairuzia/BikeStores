package com.tutorial.bikestores.production.product;

import com.tutorial.bikestores.production.brand.Brand;
import com.tutorial.bikestores.production.category.Category;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private String name;
    private Integer modelYear;
    private BigDecimal listPrice;
    private String brandName;
    private String categoryName;
}
