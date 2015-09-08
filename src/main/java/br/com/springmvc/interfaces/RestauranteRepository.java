package br.com.springmvc.interfaces;

import java.util.List;

import br.com.springmvc.modelo.Restaurante;
import br.com.springmvc.modelo.Votacao;

public interface RestauranteRepository {

	public abstract void insere(Restaurante usuario);
	public abstract void atualiza(Restaurante usuario);
	public abstract void atualiza(Votacao votacao);
	public abstract Restaurante busca(Integer id);
	public abstract void remove(Restaurante usuario);
	public abstract List<Restaurante> buscaTodos();

}