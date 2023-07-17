package com.tutorial.bikestores.sales.customer;

import jakarta.persistence.EntityNotFoundException;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerDbService implements CustomerService{
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final static Integer PAGE_SIZE = 5;
    @Override
    public Page<CustomerDTO> getAll(String name, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, PAGE_SIZE);
        return customerRepository.findAll(name, pageable);
    }

    @Override
    public CustomerDTO getSingle(Integer id) {
        Optional<Customer> optional = customerRepository.findById(id);
        Customer customer = optional.orElseThrow(()-> new EntityNotFoundException("Customer tidak ditemukan"));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public void save(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customerRepository.save(modelMapper.map(customerDTO, Customer.class));
    }

    public CustomerDTO findCustomerByEmail(String email){
        return findCustomerByEmail(email);
    }

}
