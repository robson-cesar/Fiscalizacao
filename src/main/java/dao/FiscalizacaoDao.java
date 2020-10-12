package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Empresa;
import model.Fiscalizacao;

public class FiscalizacaoDao implements Serializable{
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public FiscalizacaoDao(EntityManager em) {
		this.em = em;
	}

	public void inserir(Fiscalizacao fiscalizacao) {
		em.persist(fiscalizacao);
	}

	public Fiscalizacao busca(Empresa empresa, String mesFiscalizacao) {
//		String jpql = "SELECT f FROM Fiscalizacao f WHERE f.mesFiscalizacao = :mes";
//		TypedQuery<Fiscalizacao> query = em.createQuery(jpql, Fiscalizacao.class);
//		query.setParameter("mes", mesFiscalizacao);
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT f FROM Fiscalizacao f ");
		jpql.append("WHERE f.empresa = :pEmpresa ");
		jpql.append("AND f.mesFiscalizacao = :pMesFiscalizacao");
		TypedQuery<Fiscalizacao> query = em.createQuery(jpql.toString(), Fiscalizacao.class);
		query.setParameter("pEmpresa", empresa);
		query.setParameter("pMesFiscalizacao", mesFiscalizacao);

		try {
			return query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
}
