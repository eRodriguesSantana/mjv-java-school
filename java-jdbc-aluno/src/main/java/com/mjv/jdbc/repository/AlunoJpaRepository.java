package com.mjv.jdbc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mjv.jdbc.model.Aluno;

public class AlunoJpaRepository {
	private EntityManager em;
	public AlunoJpaRepository() {
		EntityManagerFactory entityManagerFactory 
        = Persistence.createEntityManagerFactory("ALUNOS_PU");
		em =entityManagerFactory.createEntityManager();

	}
	public void save(Aluno aluno) {
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}
	public Aluno findById(Integer id) {
		Aluno aluno = em.find(Aluno.class, id);
		return aluno;
	}
	public List<Aluno> findAll(){
		//JPQL - TODO O SELECT É BASEADO NO OBJETO
		Query query = em.createQuery("SELECT a FROM Aluno a");
		return query.getResultList();
	}
	public List<Aluno> findAllAtivo(boolean ativo){
		//JPQL - TODO O SELECT É BASEADO NO OBJETO
		Query query = em.createQuery("SELECT a FROM Aluno a WHERE a.ativo = :p1");
		query.setParameter("p1", ativo);
		return query.getResultList();
	}
}
