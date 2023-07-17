package com.tutorial.bikestores.production.product;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
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
public class ProductUpsertDTO {

    private Integer id;

    @NotBlank(message = "Nama produk tidak boleh kosong")
    @Length(min = 3, message = "Nama produk tidak boleh kurang dari 3 huruf")
    @Length(max = 5, message = "Nama produk tidak boleh lebih dari 20 huruf")
    private String name;

    private Integer modelYear;

    private BigDecimal listPrice;

    private Integer categoryId;

    private Integer brandId;

}
