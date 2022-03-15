package com.mjv.jdbc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne
	@JoinColumn(name = "id_cad")
	private Cadastro cadastro;
	
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public String getNumeroProtocolo() {
		return numeroProtocolo;
	}

	public void setNumeroProtocolo(String numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}

	public LocalDate getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDate dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getId() {
		return id;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}
	
}
