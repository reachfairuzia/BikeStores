package com.tutorial.bikestores.user;

import com.tutorial.bikestores.role.Role;
import com.tutorial.bikestores.sales.customer.Customer;
import com.tutorial.bikestores.sales.customer.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void save(AccountRegisterDTO model){
        Account account = new Account();
        account.setUsername(model.getUsername());
        account.setEmail(model.getEmail());
        account.setRole(new Role(1));
        account.setEnabled(true);
        account.setPassword(passwordEncoder.encode(model.getPassword()));
        accountRepository.save(account);
//        Customer customer = new Customer();
//        customer.setEmail(model.getEmail());
//        customer.setPhone(model.getPhone());
//        customer.setFirstName(model.getFirstName());
//        customer.setLastName(model.getLastName());
//        customerRepository.save(customer);
        Customer customer = modelMapper.map(model, Customer.class);
        customerRepository.save(customer);
    }
    public Integer getCustomerId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        String email = accountRepository.findEmailByUsername(username);
        Integer id = customerRepository.findCustomerByEmail(email).getId();
        return id;
    }
}
