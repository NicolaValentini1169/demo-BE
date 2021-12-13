package com.example.demo.security.services;

import com.example.demo.security.entities.Role;
import com.example.demo.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> findByValue(String value) {
        return roleRepository.findByValue(value);
    }

}
