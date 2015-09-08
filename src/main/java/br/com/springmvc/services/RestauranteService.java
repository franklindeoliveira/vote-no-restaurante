package br.com.springmvc.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.springmvc.interfaces.RestauranteRepository;
import br.com.springmvc.interfaces.UsuarioRepository;
import br.com.springmvc.interfaces.VotacaoRepository;
import br.com.springmvc.modelo.Restaurante;
import br.com.springmvc.modelo.Usuario;
import br.com.springmvc.modelo.Votacao;

/**
 * Service responsável pelas regras de negócios relacionadas a Restaurante.
 */
@Service
public class RestauranteService {
	
	@Autowired
	@Qualifier("usuarioJpaRepository")
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("restauranteJpaRepository")
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	@Qualifier("votacaoJpaRepository")
	private VotacaoRepository votacaoRepository;
	
	public List<Restaurante> buscaTodos() {
		return restauranteRepository.buscaTodos();
	}
	
	public List<Restaurante> rankingPessoalRestaurantes(String nome, String email) {
		Usuario usuario = usuarioRepository.buscaPorNomeEmail(nome, email).get(0);
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		List<Votacao> votacoes = usuarioRepository.busca(usuario.getId()).getVotosRestaurantes();
		Collections.sort(votacoes, new Comparator<Votacao>() {
			@Override
			public int compare(Votacao v1, Votacao v2) {
				return v1.getPosicao().compareTo(v2.getPosicao());
			}
		});
		for (Votacao votacao : votacoes) {
			restaurantes.add(votacao.getRestaurante());
		}
		return restaurantes;
	}
	
	public List<Restaurante> rankingGeralRestaurantes() {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		
		Map<Integer, List<Restaurante>> posicaoRestaurantes = new TreeMap<Integer, List<Restaurante>>();
		for (Usuario usuario : usuarioRepository.buscaTodos()) {
			for (Votacao votacao : usuario.getVotosRestaurantes()) {
				if (posicaoRestaurantes.containsKey(votacao.getPosicao())) {
					List<Restaurante> lr = new ArrayList<Restaurante>();
					lr.addAll(posicaoRestaurantes.get(votacao.getPosicao()));
					lr.add(votacao.getRestaurante());
					posicaoRestaurantes.put(votacao.getPosicao(), lr);
				} else {
					posicaoRestaurantes.put(votacao.getPosicao(), Arrays.asList(votacao.getRestaurante()));
				}
			}
		}
		Map<Integer, Restaurante> rankingPosicaoRestaurante = new TreeMap<Integer, Restaurante>();
		for (Integer posicao : posicaoRestaurantes.keySet()) {
			Map<Restaurante, Integer> restauranteVotos = new HashMap<Restaurante, Integer>();
			for (Restaurante restaurante : posicaoRestaurantes.get(posicao)) {
				if (restauranteVotos.containsKey(restaurante)) {
					restauranteVotos.put(restaurante, restauranteVotos.get(restaurante) + 1);
				} else {
					restauranteVotos.put(restaurante, 1);
				}
			}
			Integer maiorNumeroVotosPosicao = -1;
			Restaurante restauranteVencedor = null;
			for (Restaurante restauranteVoto : restauranteVotos.keySet()) {
				if (restauranteVotos.get(restauranteVoto) > maiorNumeroVotosPosicao) {
					restauranteVencedor = restauranteVoto;
					maiorNumeroVotosPosicao = restauranteVotos.get(restauranteVoto);
				}
			}
			rankingPosicaoRestaurante.put(posicao, restauranteVencedor);
		}
		
		restaurantes.addAll(rankingPosicaoRestaurante.values());
		
		return restaurantes;
	}
}
