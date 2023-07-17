package com.tutorial.bikestores.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountRegisterDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String username;
    private String password;
}
