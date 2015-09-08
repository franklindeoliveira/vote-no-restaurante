package br.com.springmvc.interfaces;

import java.util.List;

import br.com.springmvc.modelo.Votacao;

public interface VotacaoRepository {

	public abstract void insere(Votacao usuario);
	public abstract void atualiza(Votacao usuario);
	public abstract Votacao busca(Integer id);
	public abstract void remove(Votacao usuario);
	public abstract List<Votacao> buscaTodos();

}