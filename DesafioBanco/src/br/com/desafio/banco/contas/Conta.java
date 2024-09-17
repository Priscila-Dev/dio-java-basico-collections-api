package br.com.desafio.banco.contas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import br.com.desafio.banco.Cliente;

public abstract class Conta {
	
	protected String tipoConta;
	protected String nome;
	protected String cpf;
	protected String senha;
	protected double saldo;
	protected int numero;
	protected int agencia;
	
	protected Cliente cliente;
	
	protected ArrayList<Movimentacao> movimentacoes;
	public static Map<String, Conta> mapaContas = new HashMap<>();
	
	public Conta(Cliente cliente) {
		this.tipoConta = cliente.getTipoConta();
		this.agencia = cliente.getAgencia(); 
		this.numero = cliente.getNumero();
		this.saldo = cliente.getSaldo();
		this.cliente = cliente;
		this.movimentacoes = new ArrayList<Movimentacao>();
	}
	
	public String getTipoConta() {
		return tipoConta;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void sacar(double valor) {
		
		if(valor > this.saldo) {
			throw new InputMismatchException("Saque indesiponível, valor insuficiente!");
		}else {
			saldo -= valor;
			System.out.println("Saque efetuado com sucesso!");
		}
		Movimentacao movimentacao = new Movimentacao("Retirada: ", valor);
		this.movimentacoes.add(movimentacao);
	}
	
	public void depositar(double valor) {
		
		if(valor > 0) {
			saldo += valor;
			System.out.println("Depósito efetuado com sucesso!");
		}else {
			throw new InputMismatchException("Valor inválido!");
		}
		Movimentacao movimentacao = new Movimentacao("Depósito: ", valor);
		this.movimentacoes.add(movimentacao);
	}
	
	public void transferir(double valor, Conta contaDestino) {
		
		if(valor > this.saldo) {
			throw new InputMismatchException("Transferência indisponível, valor insuficiente!");
		}else if(valor > 0){
			//this.sacar(valor);
			this.saldo -= valor;
			contaDestino.depositar(valor);
			System.out.println("Transferência realizada com sucesso!");
		}
		Movimentacao movimentacao = new Movimentacao("Transferência: ", valor);
		this.movimentacoes.add(movimentacao);
	}
	
	public static String converterDataEHora(Date data) {
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY - HH:mm");
		// 08/08/2021 12:52 hrs
		return formatador.format(data);
	}
	
	public void imprimirExtrato() {

		System.out.println();
		System.out.println("******************************************************************************");
		System.out.println("*****************************  Extrato Bancário  *****************************");
		System.out.println("******************************************************************************");
		System.out.println();
		System.out.println("                Gerado em: " + converterDataEHora(new Date()));
		System.out.println();
		
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Conta: %s", this.cliente.getTipoConta()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: R$%.2f", this.saldo));
		System.out.println();
		
		for (Movimentacao movimentacao : this.movimentacoes) {
			System.out.println(movimentacao);
		}

		System.out.println();
		System.out.println("******************************************************************************");
		System.out.println("******************************************************************************");
		System.out.println("******************************************************************************");
		System.out.println();
	}
	
	public Double taxarSaque(double valor) {
		return null;
	}

	public Double taxarDeposito(double valor) {
		return null;
	}

	public Double taxarTransferencia(double valor) {
		return null;
	}
}
