package com.mjv.jdbc.app;

import java.util.List;

import com.mjv.jdbc.model.Aluno;
import com.mjv.jdbc.repository.AlunoRepository;
import com.mjv.jdbc.util.FabricaConexao;

public class EscolaApp {
	public static void main(String[] args) {
		try {
			Aluno miguel = new Aluno();
			miguel.setAltura(1.83);
			miguel.setAtivo(true);
			miguel.setNome("MIGUEL");
			miguel.setSexo("M");
			
			
			AlunoRepository alunoRepository = new AlunoRepository();
			//alunoRepository.save(miguel);
			
			List<Aluno> alunos = alunoRepository.listAll(false);
			for(Aluno a: alunos) {
				System.out.println(a);
			}
			FabricaConexao.fecharConexao();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
