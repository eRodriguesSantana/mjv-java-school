package com.mjv.jdbc.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_contrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero_protocolo")
	private String numeroProtocolo;
	
	//@Temporal(TemporalType.TIMESTAMP)
	//private Date dataHora;
	private LocalDate dataHora;
	
	@Embedded
	private Cadastro cadastro;
	
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
}
