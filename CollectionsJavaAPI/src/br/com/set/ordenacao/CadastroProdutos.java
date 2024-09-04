package br.com.set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
public class CadastroProdutos {

	private Set<Produto> produtos;

	public CadastroProdutos() {
		this.produtos = new HashSet<>();
	}
	
	public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
		produtos.add(new Produto(codigo, nome, preco, quantidade));
	}
	
	public Set<Produto> exibirProdutosPorNome() {
		Set<Produto> produtosPorNome = new TreeSet<>(produtos);
		return produtosPorNome;		
	}
	
	public Set<Produto> exibirProdutosPorPreco() {
		Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
		produtosPorPreco.addAll(produtos);	
		
		return produtosPorPreco;
	}
	
	public static void main(String[] args) {
		CadastroProdutos cadastroProdutos = new CadastroProdutos();
		
		cadastroProdutos.adicionarProduto(1L, "Produto 5", 15d, 5);
		cadastroProdutos.adicionarProduto(2L, "Produto 0", 20d, 10);
		cadastroProdutos.adicionarProduto(1L, "Produto 3", 10d, 2);
		cadastroProdutos.adicionarProduto(9L, "Produto 9", 2d, 2);
		
		System.out.println(cadastroProdutos.produtos);
		
		System.out.println(cadastroProdutos.exibirProdutosPorNome());
		
		System.out.println(cadastroProdutos.exibirProdutosPorPreco());
	}
	
}
