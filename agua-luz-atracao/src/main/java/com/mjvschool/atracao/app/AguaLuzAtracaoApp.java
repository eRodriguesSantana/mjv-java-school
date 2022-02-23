package com.mjvschool.atracao.app;

import java.util.Date;
import java.util.List;

import com.mjvschool.atracao.model.cadastro.Endereco;
import com.mjvschool.atracao.model.cadastro.Pais;
import com.mjvschool.atracao.model.cadastro.Pessoa;
import com.mjvschool.atracao.model.cadastro.Servico;
import com.mjvschool.atracao.model.contrato.Contrato;
import com.mjvschool.atracao.output.GeradorArquivoCsv;
import com.mjvschool.atracao.repository.ContratoRepository;

public class AguaLuzAtracaoApp {
	private static ContratoRepository contratoRepositorio = new ContratoRepository();
	public static void main(String[] args) {
		faseAtracao();
		faseGeracaoArquivo();
	}
	private static void faseGeracaoArquivo() {
		List<Contrato> contratos =  contratoRepositorio.listarTodos();
		GeradorArquivoCsv gerador = new GeradorArquivoCsv();
		gerador.gerarArquivo(contratos);
	}
	private static void faseAtracao() {
		Contrato contrato1 = new Contrato();
		contrato1.setNumeroProtocolo(123);
		contrato1.setServico(Servico.LUZ);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("123213");
		pessoa.setNome("Gleyson Sampaio");
		pessoa.setRg("89789");
		pessoa.setPais(Pais.BRASIL);
		
		pessoa.setCelular("897789");
		
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Santo Antonio");
		endereco.setCep("27.310-657");
		endereco.setCidade("São Paulo");
		endereco.setEstado("SP");
		endereco.setLogradouro("Rua das Marias");
		endereco.setNumero("243");
		pessoa.setEndereco(endereco);
		contrato1.setCadastro(pessoa);
		contrato1.setDataHora(new Date());
		
		contratoRepositorio.gravar(contrato1);
		
		Contrato contrato2 = new Contrato();
		contrato2.setNumeroProtocolo(78678);
		contrato2.setServico(Servico.AGUA);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setCpf("897897987");
		pessoa2.setNome("Aloisio");
		pessoa2.setRg("98908");
		pessoa2.setPais(Pais.ESTADOS_UNIDOS);
		
		pessoa2.setCelular("98789789");
		
		Endereco endereco2 = new Endereco();
		endereco2.setBairro("Santo Antonio");
		endereco2.setCep("27.310-657");
		endereco2.setCidade("São Paulo");
		endereco2.setEstado("SP");
		endereco2.setLogradouro("Rua das Marias");
		endereco2.setNumero("243");
		pessoa2.setEndereco(endereco2);
		contrato2.setCadastro(pessoa2);
		contrato2.setDataHora(new Date());
		
		contratoRepositorio.gravar(contrato2);
	}
}
