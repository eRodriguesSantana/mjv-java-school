package com.mjv.jdbc.app;

import com.mjv.jdbc.model.Cadastro;
import com.mjv.jdbc.model.Contrato;
import com.mjv.jdbc.model.Endereco;
import com.mjv.jdbc.repository.AlunoJpaRepository;

public class EscolaApp {
	public static void main(String[] args) {
		try {
			
			
			AlunoJpaRepository alunoRepository = new AlunoJpaRepository();
			//alunoRepository.findAllContratos();
			
			Contrato c;
			Cadastro cd;
			Endereco e;
			cd.setEndereco(e);
			c.setCadastro(cd);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
