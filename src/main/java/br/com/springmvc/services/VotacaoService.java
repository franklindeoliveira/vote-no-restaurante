package br.com.springmvc.services;

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
 * Service responsável pelas regras de negócios relacionadas a Votacao.
 */
@Service
public class VotacaoService {

	@Autowired
	@Qualifier("usuarioJpaRepository")
	private UsuarioRepository usuarioRepository;

	@Autowired
	@Qualifier("restauranteJpaRepository")
	private RestauranteRepository restauranteRepository;

	@Autowired
	@Qualifier("votacaoJpaRepository")
	private VotacaoRepository votacaoRepository;

	/**
	 * Cadastra uma votação.
	 * 
	 * @param nome
	 *            Nome do usuário que fez a votação.
	 * @param email
	 *            Email do usuário que fez a votação.
	 * @param ranking
	 *            String contendo o ranking dos restaurantes para este usuário.
	 *            Formato: <id do restaurante>, <posicao do restaurante no ranking>;
	 */
	public void cadastra(String nome, String email, String ranking) {
		// TODO: Melhoria: Evitar duplicação de usuário e email.
		Usuario usuario = new Usuario(nome, email);
		usuarioRepository.insere(usuario);
		for (String r : ranking.split(";")) {
			if (!r.isEmpty()) {
				Integer id = Integer.parseInt(r.split(",")[0]);
				Integer posicao = Integer.parseInt(r.split(",")[1]);
				Restaurante restaurante = restauranteRepository.busca(id);
				Votacao votacao = new Votacao(usuario, restaurante, posicao);
				votacaoRepository.atualiza(votacao);
			}
		}
	}

}
