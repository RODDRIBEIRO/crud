package com.crud.crudbasic.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.crudbasic.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
