package br.com.desafio.banco.enuns;

public enum ETipoMovimentacao {

	SAQUE("Saque", 1), DEPOSITO("Deposito", 2), TRANSFERENCIA("Transferência", 3);

	private String valor;

	private ETipoMovimentacao(String valor, int i) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
