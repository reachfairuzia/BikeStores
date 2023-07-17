package com.tutorial.bikestores.sales.customer;

import jdk.jfr.SettingDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerUpsertDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String username;
    private String password;
}
