package com.example.demo.security.repositories;

import com.example.demo.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

}
