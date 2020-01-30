package com.crud.crudbasic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crudbasic.model.Cliente;
import com.crud.crudbasic.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public void save(Cliente cliente) {
		repository.save(cliente);
	}

	public Iterable<Cliente> findAll() {
		return repository.findAll();
	}
}
