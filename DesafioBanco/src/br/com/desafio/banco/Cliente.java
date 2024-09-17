package br.com.desafio.banco;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Cliente implements Comparable<Cliente> {

	protected String tipoConta;
	protected String nome;
	protected String cpf;
	private String senha;
	private double saldo;
	protected int numero;
	protected int agencia;
	
	public static Map<String, Cliente> mapaClientes = new HashMap<>();
	public static TreeMap<String, Cliente> OrdenaClientes = new TreeMap<>();

	public Cliente(String tipoConta, String nome, String cpf, String senha, double saldo, int numero,
			int agencia) {
		super();
		this.tipoConta = tipoConta;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.saldo = saldo;
		this.numero = numero;
		this.agencia = agencia;
	}

	public String getTipoConta() {
		return tipoConta;
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

	public String getSenha() {
		return senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getNumero() {
		return numero;
	}

	public int getAgencia() {
		return agencia;
	}

	@Override
	public int compareTo(Cliente o) {
		return 0;
	}

	@Override
	public String toString() {
		return "Cliente [conta=" + tipoConta + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", saldo=" + saldo
				+ ", idConta=" + numero + ", idAgencia=" + agencia + "]";
	}
}
