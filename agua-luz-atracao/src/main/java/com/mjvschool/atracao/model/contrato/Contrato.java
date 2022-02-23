package com.mjvschool.atracao.model.contrato;

import java.util.Date;

import com.mjvschool.atracao.model.cadastro.Cadastro;
import com.mjvschool.atracao.model.cadastro.Servico;

//java beans
public class Contrato {
	private long numeroProtocolo;
	private Cadastro cadastro;
	private Date dataHora;
	private Servico servico;
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public long getNumeroProtocolo() {
		return numeroProtocolo;
	}
	public void setNumeroProtocolo(long numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}
	public Cadastro getCadastro() {
		return cadastro;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	@Override
	public String toString() {
		return "Contrato [numeroProtocolo=" + numeroProtocolo + ", dataHora=" + dataHora + "]";
	}
	
}
