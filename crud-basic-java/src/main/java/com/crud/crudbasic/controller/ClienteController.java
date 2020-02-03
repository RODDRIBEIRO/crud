package com.crud.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudbasic.model.Cliente;
import com.crud.crudbasic.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public Iterable<Cliente> findAll() {
		return service.findAll();
	}

	@PostMapping
	public void save(@RequestBody Cliente cliente) {
		service.save(cliente);
	}
}
