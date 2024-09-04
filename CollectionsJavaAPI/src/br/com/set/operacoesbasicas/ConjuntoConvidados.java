package br.com.set.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

	private Set<Convidado> convidados;

	public ConjuntoConvidados() {
		this.convidados = new HashSet<>();
	}
	
	public void adicionarConvidado(String nome, int codigoConvite) {
		convidados.add(new Convidado(nome, codigoConvite));
	}
	
	public void removerConvidadoPorCodigoConvite(int codigoConvite) {
		Convidado convidadoParaRemover = null;
		
		for(Convidado c : convidados) {
			if(c.getCodigoConvite() == codigoConvite) {
				convidadoParaRemover = c;
				break;
			}
		}
		convidados.remove(convidadoParaRemover);
	}
	
	public int contarConvidados() {
		return convidados.size();
	}
	
	public void exibirConvidados() {
		System.out.println(convidados);
	}
	
	public static void main(String[] args) {
		ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
		
		System.out.println("Existem "+ conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados.");
		
		conjuntoConvidados.adicionarConvidado("Convidado 1", 1234);
		conjuntoConvidados.adicionarConvidado("Convidado 2", 1235);
		conjuntoConvidados.adicionarConvidado("Convidado 3", 1235);
		conjuntoConvidados.adicionarConvidado("Convidado 4", 1236);
		
		conjuntoConvidados.exibirConvidados();
		
		System.out.println("Existem "+ conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados.");
		
		conjuntoConvidados.removerConvidadoPorCodigoConvite(1234);

		System.out.println("Existem "+ conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados.");

		conjuntoConvidados.exibirConvidados();
	}
	
}
