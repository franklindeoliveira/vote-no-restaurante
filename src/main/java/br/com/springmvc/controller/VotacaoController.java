package br.com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.springmvc.services.VotacaoService;

/**
 * Controller responsável por receber e encaminhar requisições relacionadas à
 * votacao.
 */
@Controller
public class VotacaoController {

	@Autowired
	private VotacaoService votacaoService;

	/**
	 * Cadastra uma votação.
	 * 
	 * @param nome
	 *            Nome do usuário que realizou a votação.
	 * @param email
	 *            Email do usuário que realizou a votação.
	 * @param ranking
	 *            Ranking dos restaurantes segundo as escolhas do usuário.
	 *            Formato: <id do restaurante>, <posicao do restaurante no ranking>;
	 * @return Forward para listagem do ranking de restaurantes.
	 */
	@RequestMapping(value = "/cadastra", method = RequestMethod.GET)
	public String cadastra(String nome, String email, String ranking) {
		votacaoService.cadastra(nome, email, ranking);
		return "forward:/restaurantes/ranking";
	}

}