package com.tutorial.bikestores.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query(value = """
            SELECT acc.email
            FROM Account acc
            WHERE acc.username = :username
            """)
    String findEmailByUsername(@Param("username")String username);
}
