package br.com.springmvc.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springmvc.interfaces.RestauranteRepository;
import br.com.springmvc.modelo.Restaurante;

/**
 * Controller responsável por receber e encaminhar requisições relacionadas à home.
 */
@Controller
public class HomeController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@PostConstruct
	public void populaRestaurantes() {
		if (restauranteRepository.buscaTodos().isEmpty()) {
			restauranteRepository.insere(new Restaurante("McDonald's", "resources/img/logos/mcdonalds.jpg"));
			restauranteRepository.insere(new Restaurante("Subway", "resources/img/logos/subway.jpg"));
			restauranteRepository.insere(new Restaurante("Outback", "resources/img/logos/outback.jpg"));
			restauranteRepository.insere(new Restaurante("Gendai", "resources/img/logos/gendai.jpg"));
			restauranteRepository.insere(new Restaurante("Feijão de Corda", "resources/img/logos/feijaodecorda.jpg"));
		}
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

}