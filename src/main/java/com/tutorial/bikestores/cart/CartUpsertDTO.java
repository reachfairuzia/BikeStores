package com.tutorial.bikestores.cart;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartUpsertDTO {
    private Integer cartId;
    private Integer customerId;
    private Integer storeId;
    private Integer productId;
    private BigDecimal unitPrice;
    private Integer quantity;
    private boolean checked;
}
