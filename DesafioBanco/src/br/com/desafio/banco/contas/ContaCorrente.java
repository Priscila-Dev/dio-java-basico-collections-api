package br.com.desafio.banco.contas;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

import br.com.desafio.banco.Cliente;

public class ContaCorrente extends Conta{
	
	DecimalFormat df = new DecimalFormat("0.00");
	private static double SAQUE = 0.1, 
			DEPOSITO = 0.1, 
			TRANSFERENCIA = 0.2;
	
	protected double totalTributado = 0.0;

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public void sacar(double valor) {
		if (valor > this.saldo) {
			throw new InputMismatchException("Saque indisponível, valor insuficiente!");
		} else {
			Double valorTaxado = taxarSaque(valor);
			if (this.saldo - valorTaxado >= 0.1) {
				this.saldo -= valorTaxado;
				this.totalTributado += SAQUE;
				
				System.out.println("Saque efetuado com sucesso!");
			}
			Movimentacao movimentacao = new Movimentacao(
					"Retirada: R$" + df.format(valor) + " - Taxa de R$" + df.format(SAQUE), valorTaxado);
			this.movimentacoes.add(movimentacao);
		}
	}

	@Override
	public void depositar(double valor) {
		if (valor < 0) {
			throw new InputMismatchException("Depósito indisponível, valor insuficiente!\n");
		} else {
			Double valorTaxado = taxarDeposito(valor);
			if (this.saldo - valorTaxado >= 0.1) {
				this.saldo += valorTaxado;
				this.totalTributado += DEPOSITO;
				
				System.out.println("Depósito efetuado com sucesso!");
			}
			Movimentacao movimentacao = new Movimentacao(
					"Depósito: R$" + df.format(valor) + " - Taxa de R$" + df.format(DEPOSITO), valorTaxado);
			this.movimentacoes.add(movimentacao);
		}
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if (valor > this.saldo) {
			throw new InputMismatchException("Transferência indisponível, saldo insuficiente!\n");
		} else {
			Double valorTaxado = taxarTransferencia(valor);
			if (this.saldo - valorTaxado >= 0.2) {
				this.saldo -= valorTaxado;
				contaDestino.saldo += valor;
				this.totalTributado += TRANSFERENCIA;
				
				System.out.println("Transferência efetuada com sucesso!");
			}
			Movimentacao movimentacao = new Movimentacao(
					"Transferência: R$" + df.format(valor) + " - Taxa de R$" + df.format(TRANSFERENCIA),
					valorTaxado);
			this.movimentacoes.add(movimentacao);
		}
	}
	
	@Override
	public Double taxarSaque(double valor) {
		return valor + SAQUE;
	}

	@Override
	public Double taxarDeposito(double valor) {
		return valor - DEPOSITO;
	}

	@Override
	public Double taxarTransferencia(double valor) {
		return valor + TRANSFERENCIA;
	}
}
