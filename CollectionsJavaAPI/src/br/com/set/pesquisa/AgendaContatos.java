package br.com.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

	private Set<Contato> contatos;

	public AgendaContatos() {
		this.contatos = new HashSet<>();
	}
	
	public void adicionarContato(String nome, int numero) {
		contatos.add(new Contato(nome, numero));
	}
	
	public void exibirContato() {
		System.out.println(contatos);
	}
	
	public Set<Contato> pesquisarPorNome(String nome) {
		Set<Contato> contatosPorNome = new HashSet<>();
		
		for(Contato c : contatos) {
			if(c.getNome().startsWith(nome)) {
				contatosPorNome.add(c);
			}
		}
		return contatosPorNome;
	}
	
	public Contato atualizarNumeroContato(String nome, int novoNumero) {
		Contato contatoAtualizado = null;
		for(Contato c : contatos) {
			if(c.getNome().equalsIgnoreCase(nome)) {
				c.setNumero(novoNumero);
				contatoAtualizado = c;
				break;
			}
		}
		return contatoAtualizado;
	}
	
	public static void main(String[] args) {
		AgendaContatos agendaContatos = new AgendaContatos();
		agendaContatos.exibirContato();
		
		agendaContatos.adicionarContato("Camila", 123456);
		agendaContatos.adicionarContato("Camila", 0);
		agendaContatos.adicionarContato("Camila Cavalcante", 111111);
		agendaContatos.adicionarContato("Camila DIO", 654321);
		agendaContatos.adicionarContato("Maria Silva", 987654);
		
		agendaContatos.exibirContato();
		
		System.out.println(agendaContatos.pesquisarPorNome("Camila"));
		
		System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Maria Silva", 556423));
		
		agendaContatos.exibirContato();

	}
	
}
