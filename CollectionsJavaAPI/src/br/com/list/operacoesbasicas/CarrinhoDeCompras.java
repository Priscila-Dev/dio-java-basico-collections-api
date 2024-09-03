package br.com.list.operacoesbasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

	private List<Item> itens;

	public CarrinhoDeCompras() {
		this.itens = new ArrayList<>();
	}

	public void adicionarItem(String nome, double preco, int quantidade) {
		Item item = new Item(nome, preco, quantidade);
		this.itens.add(item);
	}

	public void removerItem(String nome) {
		List<Item> itensParaRemover = new ArrayList<>();
		for (Item i : itens) {
			if (i.getNome().equals(nome)) {
				itensParaRemover.add(i);
			}
		}
		itens.removeAll(itensParaRemover);
	}

	public double calcularValorTotal() {
		double total = 0.0;
		for(Item item : itens) {
			total += item.calcularTotal();
		}
		return total;
	}

	public void exibirItens() {
		if (itens.isEmpty()) {
			System.out.println("O carrinho está vazio.");
		} else {
			for (Item item : itens) {
				System.out.println(itens);
			}
		}
	}

	public static void main(String[] args) {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

		carrinho.adicionarItem("Notebook", 3500.00, 1);
		carrinho.adicionarItem("Mouse", 150.00, 2);
		carrinho.adicionarItem("Teclado", 300.00, 3);
		
		System.out.println("Itens no carrinho: ");
		carrinho.exibirItens();
		
		System.out.println("\nValor total do carrinho: R$" + carrinho.calcularValorTotal());

		carrinho.removerItem("Mouse");

		System.out.println("Itens no carrinho após remover o Mouse: ");
		carrinho.exibirItens();
		
		System.out.println("\nValor total do carrinho após remover o Mouse: " + carrinho.calcularValorTotal());
		
	}
}
