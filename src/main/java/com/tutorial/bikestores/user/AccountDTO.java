package com.tutorial.bikestores.user;

import com.tutorial.bikestores.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private String username;
    private String password;
    private String email;
    private Boolean enabled;
}
