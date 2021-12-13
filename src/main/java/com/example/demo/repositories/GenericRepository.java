package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    Optional<T> findById(ID id);

}
