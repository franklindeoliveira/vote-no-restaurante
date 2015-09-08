package br.com.springmvc.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "votacao")
@TableGenerator(name = "votacao_generator", table = "TABELA_DE_IDS", pkColumnName = "tabela", 
				pkColumnValue = "votacao_id", valueColumnName = "id_atual")
public class Votacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "votacao_generator")
	private Integer id;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "restaurante_id")
	private Restaurante restaurante;
	private Integer posicao;
	
	public Votacao() {}
	
	public Votacao(Usuario usuario, Restaurante restaurante, Integer posicao) {
		this.usuario = usuario;
		this.restaurante = restaurante;
		this.posicao = posicao;
	}

	public Integer getId() {
		return id;
	}
	
	public Integer getPosicao() {
		return posicao;
	}
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	
	
}
