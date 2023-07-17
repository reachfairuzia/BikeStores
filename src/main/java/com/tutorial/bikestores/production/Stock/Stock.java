package com.tutorial.bikestores.production.Stock;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "production", name = "stocks")
public class Stock {
    @Id
    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity ")
    private Integer quantity;
}
