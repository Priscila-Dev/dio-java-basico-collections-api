package br.com.list.ordenacao;

import java.util.Comparator;

public class Pessoa implements Comparable<Pessoa>{

	private String nome;
	private int idade;
	private double autura;
	
	
	public Pessoa(String nome, int idade, double autura) {
		this.nome = nome;
		this.idade = idade;
		this.autura = autura;
	}
	
	@Override
	public int compareTo(Pessoa p) {
		return Integer.compare(idade, p.getIdade());
	}
	
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	public double getAutura() {
		return autura;
	}
	@Override
	public String toString() {
		return "Pessoas [nome=" + nome + ", idade=" + idade + ", autura=" + autura + "]";
	}
	
}

class ComparatorPorAltura implements Comparator<Pessoa> {
	
	@Override
	public int compare(Pessoa p1, Pessoa p2) {
		return Double.compare(p1.getAutura(), p2.getAutura());
	}
}
