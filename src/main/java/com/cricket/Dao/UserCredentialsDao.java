package com.cricket.Dao;

import com.cricket.entities.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsDao extends JpaRepository<UserCredentials, Integer> {

    public boolean existsByEmail(String email);
    public UserCredentials findByEmail(String email);
}
