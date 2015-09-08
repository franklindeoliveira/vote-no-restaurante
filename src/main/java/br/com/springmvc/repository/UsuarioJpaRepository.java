package br.com.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springmvc.interfaces.UsuarioRepository;
import br.com.springmvc.modelo.Usuario;

@Transactional
@Repository
public class UsuarioJpaRepository implements UsuarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insere(Usuario usuario) {
		entityManager.persist(usuario);
	}
	
	@Override
	public void atualiza(Usuario usuario) {
		entityManager.merge(usuario);
	}

	@Override
	public Usuario busca(Integer id) {
		return entityManager.find(Usuario.class, id);
	}

	@Override
	public void remove(Usuario usuario) {
		entityManager.remove(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscaTodos() {
		Query query = entityManager.createQuery("SELECT e FROM Usuario e");
	    return (List<Usuario>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscaPorNomeEmail(String nome, String email) {
		Query query = entityManager.createQuery("SELECT e FROM Usuario e where e.nome = :nome AND e.email = :email");
		query.setParameter("nome", nome).setParameter("email", email);
	    return (List<Usuario>) query.getResultList();
	}

}
