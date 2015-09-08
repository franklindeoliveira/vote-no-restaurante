package br.com.springmvc.services;

import org.junit.Assert;
import org.junit.Test;

/**
 * Classe responsável por testar o service VotacaoService.
 */
public class VotacaoServiceTest {
	
	/**
	 * Cadastra uma votação.
	 */
	@Test
	public void cadastra() {
		
		/*
		 * Ranking de restaurantes de um usuário em específico. 
		 * Formato: <id do restaurante>, <posicao do restaurante no ranking>;
		 */
		String ranking = "1,0;2,1;3,2";
		
		for (String r : ranking.split(";")) {
			if (!r.isEmpty()) {
				Integer id = Integer.parseInt(r.split(",")[0]);
				Integer posicao = Integer.parseInt(r.split(",")[1]);
				
				switch (id) {
				case 1:
					Assert.assertEquals(new Integer(0), posicao);
					break;
				case 2:
					Assert.assertEquals(new Integer(1), posicao);
					break;
				case 3:
					Assert.assertEquals(new Integer(2), posicao);
					break;
				default:
					break;
				}
			}
		}
	}
	
}
