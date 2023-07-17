package com.tutorial.bikestores.sales.customer;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private Integer id;
    private String fullName;
    private String phone;
    private String email;
    private String address;

}
