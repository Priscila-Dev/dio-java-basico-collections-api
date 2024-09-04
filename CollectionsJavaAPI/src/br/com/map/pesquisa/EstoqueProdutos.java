package br.com.map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

	private Map<Long, Produto> estoqueProdutos;

	public EstoqueProdutos() {
		this.estoqueProdutos = new HashMap<>();
	}
	
	public void adicionarProduto(Long codigo, String nome, int quantidade, double preco) {
		estoqueProdutos.put(codigo, new Produto(nome, preco, quantidade));
	}
	
	public void exibirProduto() {
		System.out.println(estoqueProdutos);
	}
	
	public double calcularCalorTotalEstoque() {
		double valorTotalEstoque = 0d;
		if(!estoqueProdutos.isEmpty()) {
			for(Produto p : estoqueProdutos.values()) {
				valorTotalEstoque += p.getQuantidade();
			}
		}
		return valorTotalEstoque;
	}
	
	public Produto obterProdutoMaisCaro() {
		Produto produtoMaisCaro = null;
		double maiorPreco = Double.MIN_VALUE;
		for(Produto p : estoqueProdutos.values()) {
			if(p.getPreco() > maiorPreco) {
				produtoMaisCaro = p;
			}
		}
		return produtoMaisCaro;
	}
	
	public static void main(String[] args) {
		EstoqueProdutos estoque = new EstoqueProdutos();
		
		estoque.exibirProduto();
		
		estoque.adicionarProduto(1L, "Produto A", 10, 5.0);
		estoque.adicionarProduto(2L, "Produto B", 5, 10.0);
		estoque.adicionarProduto(3L, "Produto C", 2, 15.0);
		estoque.adicionarProduto(4L, "Produto D", 8, 20.0);
		
		estoque.exibirProduto();
		
		System.out.println("Valor total do estoque: R$" + estoque.calcularCalorTotalEstoque());
		System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());
	}
}
