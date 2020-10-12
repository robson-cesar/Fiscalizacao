package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Uf;

public class UfDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	public UfDao(EntityManager em) {
		this.em = em;
	}

	public void inserir(Uf uf) {
		em.persist(uf);
	}
	
	public Uf busca(String nome) {
		String jpql = "SELECT u FROM Uf u WHERE u.nome = :pSigla";
		TypedQuery<Uf> query = em.createQuery(jpql, Uf.class);
		query.setParameter("pSigla", nome);
		
		try {
			return query.getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
}
