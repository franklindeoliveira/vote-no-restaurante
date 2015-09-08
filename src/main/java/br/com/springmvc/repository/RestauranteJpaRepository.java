package br.com.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springmvc.interfaces.RestauranteRepository;
import br.com.springmvc.modelo.Restaurante;
import br.com.springmvc.modelo.Votacao;

@Transactional
@Repository
public class RestauranteJpaRepository implements RestauranteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insere(Restaurante restaurante) {
		entityManager.persist(restaurante);
	}

	@Override
	public void atualiza(Restaurante restaurante) {
		entityManager.merge(restaurante);
	}
	
	@Override
	public void atualiza(Votacao votacao) {
		entityManager.merge(votacao);
	}

	@Override
	public Restaurante busca(Integer id) {
		return entityManager.find(Restaurante.class, id);
	}

	@Override
	public void remove(Restaurante restaurante) {
		entityManager.remove(restaurante);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurante> buscaTodos() {
		Query query = entityManager.createQuery("SELECT e FROM Restaurante e");
	    return (List<Restaurante>) query.getResultList();
	}

}
