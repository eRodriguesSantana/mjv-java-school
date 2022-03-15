package com.mjv.jdbc.app;

import java.time.LocalDate;

import com.mjv.jdbc.model.Cadastro;
import com.mjv.jdbc.model.Contrato;
import com.mjv.jdbc.model.Endereco;
import com.mjv.jdbc.repository.GenericRepository;

public class CadastroApp {
	public static void main(String[] args) {
		try {
			
			
			GenericRepository repository = new GenericRepository();
			
			Contrato ct = repository.findById(2);
			System.out.println(ct);
			
			
			String cpfTela = "3456345";
			Cadastro cadastro = repository.findByCpf(cpfTela);
			if(cadastro==null) {
				Cadastro cad = new Cadastro();
				cad.setCpf(cpfTela);
				cad.setNome("Nome");
				Endereco end = new Endereco();
				end.setLogradouro("rua tal");
				end.setNumero("123");
				cad.setEndereco(end);
				repository.save(cad);
			}else {
				ct = new Contrato();
				ct.setCadastro(cadastro);
				ct.setDataHora(LocalDate.now());
				ct.setNumeroProtocolo("33456");
				repository.save(ct);
				
			}
			
			
			
			if(!repository.existsCadastroByCpf(cpfTela)) {
				Cadastro cad = new Cadastro();
				cad.setCpf(cpfTela);
				cad.setNome("Nome");
				Endereco end = new Endereco();
				end.setLogradouro("rua tal");
				end.setNumero("123");
				cad.setEndereco(end);
				repository.save(cad);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
