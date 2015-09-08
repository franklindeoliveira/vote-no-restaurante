package br.com.springmvc.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

import br.com.springmvc.modelo.Restaurante;
import br.com.springmvc.modelo.Usuario;
import br.com.springmvc.modelo.Votacao;

/**
 * Classe responsável por testar o service RestauranteService.
 */
public class RestauranteServiceTest {
	
	@Test
	public void rankingPessoalRestaurantes() {
		// Ao buscar um usuário com 5 votações...
		Usuario usuario = new Usuario();
		Votacao votacao1 = new Votacao(usuario, new Restaurante("Restaurante1", "img/logo1.jpg"), 0);
		Votacao votacao2 = new Votacao(usuario, new Restaurante("Restaurante2", "img/logo2.jpg"), 1);
		Votacao votacao3 = new Votacao(usuario, new Restaurante("Restaurante3", "img/logo3.jpg"), 2);
		Votacao votacao4 = new Votacao(usuario, new Restaurante("Restaurante4", "img/logo4.jpg"), 3);
		Votacao votacao5 = new Votacao(usuario, new Restaurante("Restaurante5", "img/logo5.jpg"), 4);
		
		// ...e executar a ordenação dessas votações pela posição que o usuário escolheu...
		List<Votacao> votacoes = Arrays.asList(votacao5, votacao2, votacao1, votacao3, votacao4);
		Collections.sort(votacoes, new Comparator<Votacao>() {
			@Override
			public int compare(Votacao v1, Votacao v2) {
				return v1.getPosicao().compareTo(v2.getPosicao());
			}
		});
		
		// ... devemos ter as votações em ordem crescente das posições escolhidas.
		Assert.assertEquals(new Integer(0), votacoes.get(0).getPosicao());
		Assert.assertEquals(new Integer(1), votacoes.get(1).getPosicao());
		Assert.assertEquals(new Integer(2), votacoes.get(2).getPosicao());
		Assert.assertEquals(new Integer(3), votacoes.get(3).getPosicao());
		Assert.assertEquals(new Integer(4), votacoes.get(4).getPosicao());
	}
	
	@Test
	public void rankingGeralRestaurantes() {
		
		Usuario usuario1 = new Usuario("Usuario1", "email1@email.com");
		Usuario usuario2 = new Usuario("Usuario2", "email2@email.com");
		Usuario usuario3 = new Usuario("Usuario3", "email3@email.com");
		Usuario usuario4 = new Usuario("Usuario4", "email4@email.com");
		Usuario usuario5 = new Usuario("Usuario5", "email5@email.com");
		
		Restaurante restaurante1 = new Restaurante("Restaurante1", "img/logo1.jpg");
		Restaurante restaurante2 = new Restaurante("Restaurante2", "img/logo1.jpg");
		Restaurante restaurante3 = new Restaurante("Restaurante3", "img/logo1.jpg");
		Restaurante restaurante4 = new Restaurante("Restaurante4", "img/logo1.jpg");
		Restaurante restaurante5 = new Restaurante("Restaurante5", "img/logo1.jpg");
		
		// Votação do Usuario1
		Votacao votacaoUsuarioUm1 = new Votacao(usuario1, restaurante1, 2);
		Votacao votacaoUsuarioUm2 = new Votacao(usuario1, restaurante2, 3);
		Votacao votacaoUsuarioUm3 = new Votacao(usuario1, restaurante3, 0);
		Votacao votacaoUsuarioUm4 = new Votacao(usuario1, restaurante4, 4);
		Votacao votacaoUsuarioUm5 = new Votacao(usuario1, restaurante5, 1);
		
		// Votação do Usuario2
		Votacao votacaoUsuarioDois1 = new Votacao(usuario2, restaurante1, 4);
		Votacao votacaoUsuarioDois2 = new Votacao(usuario2, restaurante2, 2);
		Votacao votacaoUsuarioDois3 = new Votacao(usuario2, restaurante3, 0);
		Votacao votacaoUsuarioDois4 = new Votacao(usuario2, restaurante4, 3);
		Votacao votacaoUsuarioDois5 = new Votacao(usuario2, restaurante5, 1);
				
		// Votação do Usuario3
		Votacao votacaoUsuarioTres1 = new Votacao(usuario3, restaurante1, 4);
		Votacao votacaoUsuarioTres2 = new Votacao(usuario3, restaurante2, 3);
		Votacao votacaoUsuarioTres3 = new Votacao(usuario3, restaurante3, 0);
		Votacao votacaoUsuarioTres4 = new Votacao(usuario3, restaurante4, 2);
		Votacao votacaoUsuarioTres5 = new Votacao(usuario3, restaurante5, 1);
		
		// Votação do Usuario4
		Votacao votacaoUsuarioQuatro1 = new Votacao(usuario4, restaurante1, 4);
		Votacao votacaoUsuarioQuatro2 = new Votacao(usuario4, restaurante2, 2);
		Votacao votacaoUsuarioQuatro3 = new Votacao(usuario4, restaurante3, 0);
		Votacao votacaoUsuarioQuatro4 = new Votacao(usuario4, restaurante4, 3);
		Votacao votacaoUsuarioQuatro5 = new Votacao(usuario4, restaurante5, 1);
		
		// Votação do Usuario5
		Votacao votacaoUsuarioCinco1 = new Votacao(usuario5, restaurante1, 1);
		Votacao votacaoUsuarioCinco2 = new Votacao(usuario5, restaurante2, 2);
		Votacao votacaoUsuarioCinco3 = new Votacao(usuario5, restaurante3, 4);
		Votacao votacaoUsuarioCinco4 = new Votacao(usuario5, restaurante4, 3);
		Votacao votacaoUsuarioCinco5 = new Votacao(usuario5, restaurante5, 0);
		
		usuario1.setVotacoes(Arrays.asList(votacaoUsuarioUm1,
				votacaoUsuarioUm2, votacaoUsuarioUm3, votacaoUsuarioUm4,
				votacaoUsuarioUm5));
		usuario2.setVotacoes(Arrays.asList(votacaoUsuarioDois1,
				votacaoUsuarioDois2, votacaoUsuarioDois3, votacaoUsuarioDois4,
				votacaoUsuarioDois5));
		usuario3.setVotacoes(Arrays.asList(votacaoUsuarioTres1,
				votacaoUsuarioTres2, votacaoUsuarioTres3, votacaoUsuarioTres4,
				votacaoUsuarioTres5));
		usuario4.setVotacoes(Arrays.asList(votacaoUsuarioQuatro1,
				votacaoUsuarioQuatro2, votacaoUsuarioQuatro3, votacaoUsuarioQuatro4,
				votacaoUsuarioQuatro5));
		usuario5.setVotacoes(Arrays.asList(votacaoUsuarioCinco1,
				votacaoUsuarioCinco2, votacaoUsuarioCinco3, votacaoUsuarioCinco4,
				votacaoUsuarioCinco5));
		
		// Recupera a lista de todos os usuários cadastrados...
		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5);
		
		Map<Integer, List<Restaurante>> posicaoRestaurantes = new TreeMap<Integer, List<Restaurante>>();
		for (Usuario usuario : usuarios) {
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
		
		List<Restaurante> restaurantes = new ArrayList<Restaurante>(rankingPosicaoRestaurante.values());
		
		// Resultado esperado:
		// 0 - r3, r3, r3, r3, r5 		- r3 - ok
		// 1 - r5, r5, r5, r5, r1 		- r5 - ok
		// 2 - r1, r2, r4, r2, r2 		- r2 - ok
		// 3 - r2, r4, r2, r4, r4 		- r4 - ok
		// 4 - r4, r1, r1, r1, r3 		- r1 - ok
		
		Assert.assertEquals(restaurantes.get(0).getNome(), "Restaurante3");
		Assert.assertEquals(restaurantes.get(1).getNome(), "Restaurante5");
		Assert.assertEquals(restaurantes.get(2).getNome(), "Restaurante2");
		Assert.assertEquals(restaurantes.get(3).getNome(), "Restaurante4");
		Assert.assertEquals(restaurantes.get(4).getNome(), "Restaurante1");
	}
}
