package com.tutorial.bikestores.cart;

import org.hibernate.boot.beanvalidation.IntegrationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("""
            SELECT c.cartId
            FROM Cart c
            WHERE c.customerId = :customerId AND c.storeId = :storeId AND c.productId = :productId
            """)
    Integer getCartId(@Param("customerId") Integer customerId,
                      @Param("storeId") Integer storeId,
                      @Param("productId") Integer productId);
    @Query("""
            SELECT c.quantity
            FROM Cart c
            WHERE c.cartId = :cartId
            """)
    Integer getQuantity(@Param("cartId") Integer cartId);

    @Query(value = """
            SELECT new com.tutorial.bikestores.cart.CartIndexDTO(c.cartId, c.customerId,
            s.storeName, p.name, c.unitPrice, c.quantity, c.checked)
            FROM Cart c
            JOIN Stores s on s.storeId = c.storeId
            JOIN Product p on p.id = c.productId
            WHERE c.customerId = :custId
            """)
    List<CartIndexDTO> getCartByCustomerId (@Param("custId") Integer custId);
}
