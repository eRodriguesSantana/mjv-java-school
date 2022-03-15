package com.mjv.jdbc.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mjv.jdbc.model.Cadastro;
import com.mjv.jdbc.model.Contrato;

public class GenericRepository {
	private EntityManager em;
	public GenericRepository() {
		EntityManagerFactory entityManagerFactory 
        = Persistence.createEntityManagerFactory("ALUNOS_PU");
		em =entityManagerFactory.createEntityManager();

	}
	public void save(Object entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	public Cadastro findByCpf(String cpf) {
		Query q = em.createQuery("SELECT c FROM Cadastro c WHERE c.cpf = :cpf ");
		q.setParameter("cpf", cpf);
		Cadastro oCara =  (Cadastro) q.getSingleResult();
		return oCara;
	}
	public boolean existsCadastroByCpf(String cpf) {
		Cadastro existe = findByCpf(cpf);
		if(existe!=null)
			return true;
		else
			return false;
	}
	public Contrato findById(Integer id) {
		return em.find(Contrato.class, id);
	}
	
}
