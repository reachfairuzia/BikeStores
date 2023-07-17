package com.tutorial.bikestores.sales.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query("""
//            SELECT new com.tutorial.bikestores.sales.customer.CustomerDTO(c.customerId, c.firstName, c.lastName,
//            c.phone, c.email, c.street, c.city, c.state, c.zipCode)
//            FROM Customer c
//
//            """)
    @Query(value = """
            SELECT new com.tutorial.bikestores.sales.customer.CustomerDTO(cus.id,CONCAT(cus.firstName, ' ', cus.lastName),
            cus.phone, cus.email, CONCAT(cus.street, ' (' , cus.city, '), ', cus.state, ', [', cus.zipCode, ']'))
            FROM Customer cus
            WHERE CONCAT(cus.firstName, ' ', cus.lastName) LIKE %:name%
            """)
    Page<CustomerDTO> findAll(@Param("name") String name, Pageable pageable);

    @Query(value = """
            SELECT new com.tutorial.bikestores.sales.customer.CustomerDTO(cus.id,CONCAT(cus.firstName, ' ', cus.lastName),
            cus.phone, cus.email, CONCAT(cus.street, ' (' , cus.city, '), ', cus.state, ', [', cus.zipCode, ']'))
            FROM Customer cus
            WHERE cus.email = :email
            """)
    CustomerDTO findCustomerByEmail(@Param("email") String email);
}
