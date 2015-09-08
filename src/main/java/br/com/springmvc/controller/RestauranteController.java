package br.com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.springmvc.modelo.Restaurante;
import br.com.springmvc.services.RestauranteService;

/**
 * Controller responsável por receber e encaminhar requisições relacionadas à restaurantes.
 */
@Controller
public class RestauranteController {
	
	@Autowired
	RestauranteService restauranteService;

	/**
	 * Retorna todos os restaurantes cadastrados.
	 * @return Lista de restaurantes cadastrados.
	 */
	@RequestMapping(value="/restaurantes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Restaurante> restaurantes() {
		return restauranteService.buscaTodos();
	}
	
	/**
	 * Retorna o ranking dos restaurantes mais votados.
	 * @param model Model para registro do ranking a ser renderizado na View.
	 * @param nome Nome do usuário que realizou a votação.
	 * @param email Email do usuário que realizou a votação.
	 * @return Página do ranking de restaurantes.
	 */
	@RequestMapping(value="/restaurantes/ranking", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String ranking(Model model, String nome, String email) {
		model.addAttribute("restaurantesRankingPessoal", restauranteService.rankingPessoalRestaurantes(nome, email));
		model.addAttribute("restaurantesRankingGeral", restauranteService.rankingGeralRestaurantes());
		return "ranking";
	}
	
}
