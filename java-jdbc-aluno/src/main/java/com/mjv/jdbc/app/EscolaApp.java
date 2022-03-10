package com.mjv.jdbc.app;

import com.mjv.jdbc.model.Aluno;
import com.mjv.jdbc.repository.AlunoRepository;
import com.mjv.jdbc.util.FabricaConexao;

public class EscolaApp {
	public static void main(String[] args) {
		try {
			Aluno athos = new Aluno();
			athos.setAltura(1.83);
			athos.setAtivo(true);
			athos.setNome("ATHOS");
			athos.setSexo("M");
			
			Aluno marcelle = new Aluno();
			marcelle.setAltura(1.88);
			marcelle.setAtivo(true);
			marcelle.setNome("MARCELLE");
			marcelle.setSexo("F");
			
			
			AlunoRepository alunoRepository = new AlunoRepository();
			alunoRepository.gravar(athos);
			alunoRepository.gravar(marcelle);
			
			FabricaConexao.fecharConexao();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
