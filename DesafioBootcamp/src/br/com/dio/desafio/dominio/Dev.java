package br.com.dio.desafio.dominio;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class Dev {

	private String nome;
	private String cpf;
	private String senha;

	public static Map<String, Dev> mapaDevs = new HashMap<>();
	public static TreeMap<String, Dev> OrdenaDevs = new TreeMap<>();

	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

	public Dev(String nome, String cpf, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	/*
	 * public void inscreverBootcamp(Bootcamp bootcamp) {
	 * this.conteudosInscritos.addAll(bootcamp.getConteudos());
	 * bootcamp.getDevsInscritos().add(this); }
	 * 
	 * public void progredir() { Optional<Conteudo> conteudo
	 * =this.conteudosInscritos.stream().findFirst();
	 * 
	 * if(conteudo.isPresent()) { this.conteudosConcluidos.add(conteudo.get());
	 * this.conteudosInscritos.remove(conteudo.get()); }else {
	 * System.out.println("Você não está matriculado em nenhum conteúdo!"); } }
	 */

	public void inscreverConteudo(Conteudo conteudo) {
		// Adiciona o conteúdo à lista de conteúdos inscritos
		this.conteudosInscritos.add(conteudo);
	}

	public void concluirConteudo(Conteudo conteudo) {
		if (conteudosInscritos.contains(conteudo)) {
			conteudosInscritos.remove(conteudo);
			conteudosConcluidos.add(conteudo);
		}
	}

	public double calcularXp() {
		return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
	}

	public int calcularCargaHoraria() {
		return this.conteudosConcluidos.stream().mapToInt(Conteudo::calcularCargaHoraria).sum();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscritos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && Objects.equals(nome, other.nome);
	}

}
