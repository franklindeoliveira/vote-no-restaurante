package br.com.springmvc.interfaces;

import java.util.List;

import br.com.springmvc.modelo.Usuario;

public interface UsuarioRepository {

	public abstract void insere(Usuario usuario);
	public abstract void atualiza(Usuario usuario);
	public abstract Usuario busca(Integer id);
	public abstract void remove(Usuario usuario);
	public abstract List<Usuario> buscaTodos();
	List<Usuario> buscaPorNomeEmail(String nome, String email);

}