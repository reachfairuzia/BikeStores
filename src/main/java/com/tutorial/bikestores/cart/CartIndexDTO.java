package com.tutorial.bikestores.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartIndexDTO {
    private Integer cartId;
    private Integer customerId;
    private String storeName;
    private String productName;
    private BigDecimal unitPrice;
    private Integer quantity;
    private boolean checked;
}
