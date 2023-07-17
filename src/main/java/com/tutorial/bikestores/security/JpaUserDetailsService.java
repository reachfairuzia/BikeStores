package com.tutorial.bikestores.security;

import com.tutorial.bikestores.user.Account;
import com.tutorial.bikestores.user.AccountRepository;
import com.tutorial.bikestores.user.Account;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found, try again!"));
        return new SecurityUserDetails(account);
    }
}
