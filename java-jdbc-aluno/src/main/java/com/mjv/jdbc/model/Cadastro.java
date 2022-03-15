package com.mjv.jdbc.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Cadastro {
	private String cpf;
	private String nome;
	@Embedded
	private Endereco endereco;
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
