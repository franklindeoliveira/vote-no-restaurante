package br.com.springmvc.modelo;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "usuario")
@TableGenerator(name = "usuario_generator", table = "tabela_de_ids", pkColumnName = "tabela", 
				pkColumnValue = "usuario_id", valueColumnName = "id_atual")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "usuario_generator")
	private Integer id;
	private String nome;
	private String email;
	@OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private List<Votacao> votacoes;
	
	public Usuario() {}
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public Usuario(String nome, String email, List<Votacao> votacoes) {
		this.nome = nome;
		this.email = email;
		this.votacoes = votacoes;
	}
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Votacao> getVotosRestaurantes() {
		if (votacoes == null) {
			return Collections.emptyList();
		}
		return votacoes;
	}
	public void setVotacoes(List<Votacao> votacoes) {
		this.votacoes = votacoes;
	}

}
