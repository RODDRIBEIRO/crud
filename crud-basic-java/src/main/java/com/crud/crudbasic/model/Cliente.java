package com.crud.crudbasic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	private Boolean ativo;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Endereco> enderecos = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Contato> contatos = new HashSet<>();
}
