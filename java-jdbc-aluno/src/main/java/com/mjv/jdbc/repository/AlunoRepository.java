package com.mjv.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mjv.jdbc.model.Aluno;
import com.mjv.jdbc.util.FabricaConexao;

public class AlunoRepository {
	private Connection conexao;

	public AlunoRepository() {
		try {
			FabricaConexao.abrirConexao();
			conexao = FabricaConexao.getConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void save(Aluno aluno) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into tab_aluno (nome, altura,sexo, ativo,cd_cidade)");
			sql.append(" values (?,?,?,?,?)");
			PreparedStatement procedimentoSql = conexao.prepareStatement(sql.toString());
			procedimentoSql.setString(1, aluno.getNome());
			if (aluno.getAltura() == null)
				procedimentoSql.setNull(2, java.sql.Types.NULL);
			else
				procedimentoSql.setDouble(2, aluno.getAltura());

			procedimentoSql.setString(3, aluno.getSexo());
			procedimentoSql.setBoolean(4, aluno.isAtivo());
			procedimentoSql.setInt(5, 2211001);// jamais deve ser um valor fixo

			procedimentoSql.execute();

			System.out.println("registro inserido com sucesso");
			procedimentoSql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Aluno aluno) {
		try {

			StringBuilder sql = new StringBuilder();
			sql.append(" update tab_aluno set nome = ?, altura = ?, sexo = ?,");
			sql.append(" ativo = ?, cd_cidade = ? where id = ?");

			PreparedStatement procedimentoSql = conexao.prepareStatement(sql.toString());
			procedimentoSql.setString(1, aluno.getNome());
			if (aluno.getAltura() == null)
				procedimentoSql.setNull(2, java.sql.Types.NULL);
			else
				procedimentoSql.setDouble(2, aluno.getAltura());

			procedimentoSql.setString(3, aluno.getSexo());
			procedimentoSql.setBoolean(4, aluno.isAtivo());
			procedimentoSql.setInt(5, 2211001);// jamais deve ser um valor fixo
			procedimentoSql.setInt(6, aluno.getId());
			procedimentoSql.execute();

			System.out.println("registro atualizado com sucesso");
			procedimentoSql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Aluno> listAll(Boolean ativo) {
		List<Aluno> alunos = new ArrayList<>();
		try {
			PreparedStatement procedimentoSql = conexao.prepareStatement("SELECT * FROM tab_aluno where ativo = ?"); 
			procedimentoSql.setBoolean(1, ativo);
			
			ResultSet rs = procedimentoSql.executeQuery();
			while(rs.next()) {
				
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setAltura(rs.getDouble("altura"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setAtivo(rs.getBoolean("ativo"));
				
				alunos.add(aluno);
			}
			procedimentoSql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alunos;
	}

}
