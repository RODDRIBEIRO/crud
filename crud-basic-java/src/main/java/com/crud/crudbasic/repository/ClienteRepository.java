package com.crud.crudbasic.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.crudbasic.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
