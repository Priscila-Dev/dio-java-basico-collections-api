package br.com.desafio.banco.contas;

import java.text.DecimalFormat;
import java.util.Date;

import br.com.desafio.banco.enuns.ETipoMovimentacao;

public class Movimentacao {

	DecimalFormat df = new DecimalFormat("0.00");
	private String descricao;
	private Date data;
	private Double valor;

	public Movimentacao(String descricao, Double valor) {
		this.descricao = descricao;
		this.data = new Date();
		this.valor = valor;
	}

	public Movimentacao(ETipoMovimentacao transferencia, Double valorSacado, Conta contaDestino) {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		String dataFormatada = Conta.converterDataEHora(this.getData());
		return this.getDescricao() + " - " + dataFormatada + " - R$ " + df.format(this.getValor());
	}
}
