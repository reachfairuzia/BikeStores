package com.tutorial.bikestores.sales.customer;

import org.springframework.data.domain.Page;

public interface CustomerService {
    Page<CustomerDTO> getAll(String name, int pageNumber);
    CustomerDTO getSingle(Integer id);
    void save(CustomerDTO customerDTO);
    CustomerDTO findCustomerByEmail(String email);
}
