package br.com.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springmvc.interfaces.VotacaoRepository;
import br.com.springmvc.modelo.Votacao;

@Transactional
@Repository
public class VotacaoJpaRepository implements VotacaoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insere(Votacao votacao) {
		entityManager.persist(votacao);
	}
	
	@Override
	public void atualiza(Votacao votacao) {
		entityManager.merge(votacao);
	}

	@Override
	public Votacao busca(Integer id) {
		return entityManager.find(Votacao.class, id);
	}

	@Override
	public void remove(Votacao votacao) {
		entityManager.remove(votacao);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Votacao> buscaTodos() {
		Query query = entityManager.createQuery("SELECT e FROM Votacao e");
	    return (List<Votacao>) query.getResultList();
	}

}
